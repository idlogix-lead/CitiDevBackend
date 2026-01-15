package com.citidev.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.compiere.model.MProject;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citidev.client.impl.ProjectApi;
import com.citidev.dto.ProjectDTO;

public class ProjectService {

	private static final Logger log = LoggerFactory.getLogger(ReceiptService.class);

    private final ProjectApi projectApi;

    public ProjectService() {
    	this.projectApi = new ProjectApi();
    	
    }

    public List<ProjectDTO> getAllProjects() {
	       return projectApi.getAllProjects();
	    }
    
    public ProjectDTO getProjectById(String id) {
        return projectApi.getProjectById(id);
    }
    
    public ProjectDTO updateProject(String id, ProjectDTO dto) {
    	return projectApi.updateProject(id, dto);
    }
    
   public int syncedProjectsFromSalesForce() {
	   int syncedCount = 0;
	   List<ProjectDTO> dtos = getAllProjects();
	   if(dtos == null || dtos.isEmpty()) {
		   log.warn("No projects found in salesforce");
		   return 0;
	   }
	   Map<String, MProject> existing = fetchExistingProjects(
               dtos.stream().map(ProjectDTO::getId).collect(Collectors.toList())
       );
	  
	   for(ProjectDTO dto : dtos) {
		  
		   MProject project = existing.get(dto.getId());
		   if(project == null) {
			   project = new MProject(Env.getCtx(), 0, null);
		   }
		   populateProject(project, dto);
		   project.saveEx();
	
		   syncedCount++;
	   }
	   return syncedCount;	
	   
   }
   
   private Map<String, MProject> fetchExistingProjects(List<String> sfIds){
	   Map<String, MProject> data = new HashMap<>();
	   if (sfIds == null || sfIds.isEmpty())
           return data;
	   
	   String placeHolders = sfIds.stream().map(i -> "?").collect(Collectors.joining(","));
	   String where = "SF_UID IN (" + placeHolders + ")";
	   List <MProject> project = new Query (Env.getCtx(), MProject.Table_Name, where, null)
	   .setParameters(sfIds.toArray())
	   .list();
	   
	   for(MProject pro : project) {
		   data.put((String)pro.get_Value("SF_UID"), pro);
	   }
	   return data;
   }
   
   private void populateProject(MProject project, ProjectDTO dto) {
	   project.set_ValueOfColumn("SF_UID", dto.getId());
	   if(dto.getName() != null) {
		   project.setName(dto.getName());
	   } else {
		   log.error("The Name" + dto.getName() + "is not found");
	   }
	   project.setName(dto.getName());
	   project.setC_Currency_ID(304);
	   project.set_TrxName(dto.getBank_name__c());
	   if(dto.getBank_name__c() != null) {
		   project.set_TrxName(dto.getBank_name__c());
	   } else {
		   log.error("The Business partner" + dto.getBank_name__c() + "does not found");
	   }
	   project.set_ValueOfColumn("Partner Location", dto.getProject_Location__c());

   }
   
   
}

