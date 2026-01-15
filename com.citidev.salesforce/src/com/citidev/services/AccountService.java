package com.citidev.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MLocation;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;
import com.citidev.client.impl.AccountApi;
import com.citidev.dto.AccountDTO;

public class AccountService {

    private final AccountApi accountApi;

    public AccountService() {
    	this.accountApi = new AccountApi();
    }

    public List<AccountDTO> getAllAccounts() {
        return accountApi.getAllAccounts();
    }
    
    public AccountDTO getAccountById(String id) {
        return accountApi.getAccountById(id); 
    }
    
    public void updateAccount(String id, AccountDTO dto) {
        accountApi.updateAccount(id, dto.getUpdatePayload());
    }
    

    
    public int syncAccountsFromSalesforce() {
    	List<AccountDTO> newDTOs = new ArrayList<AccountDTO>();
    	List<MUser> newUsers = new ArrayList<MUser>();
        List<AccountDTO> dtos = getAllAccounts();
        Map<String, MUser> existing = fetchExistingUsers(
                dtos.stream().map(AccountDTO::getId).collect(Collectors.toList()));

        for (AccountDTO dto : dtos) {
            MUser user = existing.get(dto.getId());
            if (user == null) {
                user = new MUser(Env.getCtx(), 0, null);
                newDTOs.add(dto);
                newUsers.add(user);
            }
            user = populateUser(user, dto);
            user.save();
        }
        if(newDTOs.size()>0) {
        	try {
        		createRole(newUsers);
                createPendingBPartners(newDTOs);
			} catch (Exception e) {
				// TODO: handle exception
			}
        
        }
        
        return dtos.size();
    }
    
//    public int syncAccountsByIdFromSalesforce(String acc) {
//    	int rs = 0;
//    	List<AccountDTO> newDTOs = new ArrayList<AccountDTO>();
//    	List<MUser> newUsers = new ArrayList<MUser>();
//    	AccountDTO account = getAccountById(acc);
//
//	    if (account == null) {
//	        System.out.println("No Account found for ID: " + acc);
//	        return 0;
//	    }
//
////	    List<AccountDTO> dtos = Collections.singletonList(account);  
//        Map<String, MUser> existing = fetchExistingUsers(Collections.singletonList(account.getId()));
//
////        for (AccountDTO dto : dtos) {
//            MUser user = existing.get(account.getId());
//            if (user == null) {
//                user = new MUser(Env.getCtx(), 0, null);
//                newDTOs.add(account);
//                newUsers.add(user);
//            }
////            user.delete(true);
//            user = populateUser(user, account);
//            user.save();
////        }
//        if(newDTOs.size()>0) {
//        	
//        	try {
//        		createRole(newUsers);
//                rs = createPendingBPartners(newDTOs);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//        
//        }
//        
//        return rs;
//    }
    public int syncAccountsByIdFromSalesforce(String acc) {
        int rs = 0;
        List<AccountDTO> newDTOs = new ArrayList<>();
        List<MUser> newUsers = new ArrayList<>();

        AccountDTO account = getAccountById(acc);

        if (account == null) {
            System.out.println("No Account found for ID: " + acc);
            return 0;
        }

        Map<String, MUser> existing = fetchExistingUsers(Collections.singletonList(account.getId()));
        MUser user = existing.get(account.getId());

        if (user == null) {
            user = new MUser(Env.getCtx(), 0, null);
            newDTOs.add(account);
            newUsers.add(user);
//            System.out.println("Creating new user for Account: " + account.getName());
        } 
//        else {
//            if (user.getC_BPartner_ID() <= 0) {
//                newDTOs.add(account);
//                newUsers.add(user);
////                System.out.println("User exists but has no BPartner, creating BPartner for: " + account.getName());
//            }
//        }

        user = populateUser(user, account);
        user.saveEx();

        if (!newDTOs.isEmpty()) {
            try {
                createRole(newUsers);
                rs = createPendingBPartnersforsingleId(newDTOs);
                user.setC_BPartner_ID(rs);
                user.saveEx();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("❌ Error creating Role or BPartner: " + e.getMessage());
            }
        }

        return rs;
    }

    
    private Map<String, MUser> fetchExistingUsers(List<String> ids) {
    	
        Map<String, MUser> data = new HashMap<>();
        if (ids.isEmpty())
            return data;

        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
        String where = "SF_UID IN (" + placeholders + ")";
        List<MUser> objects = new Query(Env.getCtx(), MUser.Table_Name, where, null)
                .setParameters(ids.toArray()) 
                		.list();
        objects.stream()
        .filter(obj -> obj.get_Value("SF_UID") != null)
        .forEach(obj -> data.put((String) obj.get_Value("SF_UID"), obj));
        return data;
    }
        
    private int createPendingBPartnersforsingleId(List<AccountDTO> dtos) {
//    	ids.stream().collect(Collectors.joining(","))
        List<String> ids = dtos.stream()
                .map(AccountDTO::getId)
                .filter(Objects::nonNull)
                .toList();

        Map<String, MBPartner> data = new HashMap<>();
        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(", "));
        String where = "SF_UID IN (" + placeholders + ")";
        List<MBPartner> objects = new Query(Env.getCtx(), MBPartner.Table_Name, where, null)
                .setParameters(ids.toArray())
                .list();
        objects.forEach(object ->
                data.put((String) object.get_Value("SF_UID"), object)
        );
        Set<String> existingIds = data.keySet();
        List<AccountDTO> newUsers = dtos.stream()
                .filter(dto -> !existingIds.contains(dto.getId()))
                .toList();
        int bp = 0;
        for (AccountDTO userDTO : newUsers) {
            try {
                bp = insertBP(userDTO);
            } catch (Exception e) {
//                log.log(Level.WARNING, "Failed to insert BP for user: " + userDTO.getId(), e);
            }
        }
//        return single integer value in case for singlecall by Id 
        return bp;
        
    }
    private int createPendingBPartners(List<AccountDTO> dtos) {
//    	ids.stream().collect(Collectors.joining(","))
        List<String> ids = dtos.stream()
                .map(AccountDTO::getId)
                .filter(Objects::nonNull)
                .toList();

        Map<String, MBPartner> data = new HashMap<>();
        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(", "));
        String where = "SF_UID IN (" + placeholders + ")";
        List<MBPartner> objects = new Query(Env.getCtx(), MBPartner.Table_Name, where, null)
                .setParameters(ids.toArray())
                .list();
        objects.forEach(object ->
                data.put((String) object.get_Value("SF_UID"), object)
        );
        Set<String> existingIds = data.keySet();
        List<AccountDTO> newUsers = dtos.stream()
                .filter(dto -> !existingIds.contains(dto.getId()))
                .toList();
        Map<String, MUser> userMap = new HashMap<>();
        if (!ids.isEmpty()) {
            List<MUser> existingUsers = new Query(Env.getCtx(), MUser.Table_Name, where, null)
                    .setParameters(ids.toArray())
                    .list();
            existingUsers.forEach(u ->
                    userMap.put((String) u.get_Value("SF_UID"), u)
            );
        }
        
        int bp = 0;
        for (AccountDTO userDTO : newUsers) {
            try {
                bp = insertBP(userDTO);
                MUser user = userMap.get(userDTO.getId());
                if (user != null) {
                	user.setC_BPartner_ID(bp);
                    user.saveEx();
                }
//                MUser user = new Query(Env.getCtx(), MUser.Table_Name, "SF_UID=?", null)
//                        .setParameters(userDTO.getId())
//                        .first();
//                if (user != null) {
//                    user.setC_BPartner_ID(bp);
//                    user.saveEx();
//                }
            } catch (Exception e) {
//                log.log(Level.WARNING, "Failed to insert BP for user: " + userDTO.getId(), e);
            }
        }
//        return single integer value in case for singlecall by Id 
        return bp;
        
    }

    void createRole(List<MUser> users){
    	
    	for (MUser mUser : users) {
    		MUserRoles userRole = new MUserRoles(Env.getCtx(), 0, 0, null);
        	userRole.setAD_User_ID(mUser.get_ID());
        	userRole.setAD_Role_ID(102);
        	userRole.save();
		}	
    }
    
    private int insertBP(AccountDTO dto) throws Exception{
    	
    	MBPartner bPartner = new MBPartner(Env.getCtx(), 0, null);
    	bPartner.setValue(dto.getId());
    	bPartner.setName(dto.getId());
    	bPartner.setIsCustomer(true);
    	bPartner.setIsVendor(true);
    	bPartner.setC_BP_Group_ID(103);
    	bPartner.set_ValueOfColumn("SF_AccountID", dto.getId());
    	bPartner.set_ValueOfColumn("SF_UID", dto.getId());
    	bPartner.save();
		MBPartnerLocation bpLocation = new MBPartnerLocation(bPartner);
		MLocation location = new MLocation(Env.getCtx(), 0, null);
		location.setC_Country_ID(332);
		if(dto.getBillingAddress()!=null)
			location.setAddress1(dto.getBillingAddress().getStreet() + dto.getBillingAddress().getCity() + dto.getBillingAddress().getCountry());
		else
			location.setAddress1(bPartner.getName());
		location.save();
		bpLocation.setC_Location_ID(location.get_ID());
		bpLocation.setName(bPartner.getName());
		bpLocation.setC_BPartner_ID(bPartner.get_ID());
		bpLocation.save();
//		return in case for single data fetch
		return bPartner.get_ID();
    }
    
    public MUser populateUser(MUser user, AccountDTO dto) {
   	 user.set_ValueOfColumn("SF_AccountID", dto.getId());
   	 user.set_ValueOfColumn("SF_UID", dto.getId());
   	 user.setName(dto.getPassport());
        user.set_ValueOfColumn("Passport", dto.getPassport());
        user.set_ValueOfColumn("FirstName", dto.getFname());
        user.set_ValueOfColumn("LastName", dto.getLname());
        user.set_ValueOfColumn("FullName", dto.getName());
        user.setEMail(dto.getPersonEmail());
        user.setPhone(dto.getPersonMobilePhone());
        user.setC_BPartner_ID(0);
        user.setTitle(dto.getProjectName());
        if(user.get_ID()<=0)
        	user.setIsActive(false);
        return user;
   }

//	private Map<Integer, MBPartnerLocation> fetchExistingBPartnerLocations(Properties ctx, String trxName, List<Integer> ids) {
//	    Map<Integer, MBPartnerLocation> data = new HashMap<>();
//	    if (ids.isEmpty())
//	        return data;
//	
//	    String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
//	    String where = "C_BPartner_ID IN (" + placeholders + ")";
//	    List<MBPartnerLocation> objects = new Query(ctx, MBPartnerLocation.Table_Name, where, trxName)
//	            .setParameters(ids.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(",")))
//	            .list();
//	
//	    for (MBPartnerLocation object : objects) {
//	        int id = object.get_ID();
//	        if (id > 0)
//	        	data.put(id, object);
//	    }
//	    return data;
//	}
    
//    private Map<Integer, MUserRoles> fetchExistingUsersRoles(Properties ctx, String trxName, List<Integer> ids,List<UserDTO> dtos) {
//        Map<Integer, MUserRoles> data = new HashMap<>();
//        if (ids.isEmpty())
//            return data;
//
//        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
//        String where = "AD_User_ID IN (" + placeholders + ")";
//        List<MUserRoles> objects = new Query(ctx, MUserRoles.Table_Name, where, trxName)
//                .setParameters(ids.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(",")))
//                .list();
//
//        for (MUserRoles object : objects) {
//            int id = object.get_ID();
//            if (id > 0)
//                data.put(id, object);
//            
//        }
//        return data;
//    }
    
}

