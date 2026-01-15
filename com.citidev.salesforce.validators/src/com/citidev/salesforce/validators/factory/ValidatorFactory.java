package com.citidev.salesforce.validators.factory;

import org.adempiere.base.IModelValidatorFactory;
import org.compiere.model.ModelValidator;

import com.citidev.salesforce.validators.modelvalidators.UserAccountValidator;
import com.citidev.salesforce.validators.modelvalidators.AllocationPayScheduleValidator;


public class ValidatorFactory implements IModelValidatorFactory {

	@Override
	public ModelValidator newModelValidatorInstance(String className) {
		// TODO Auto-generated method stub
		if(className.equals("com.citidev.salesforce.validators.modelvalidators.UserAccountValidator"))
			return new UserAccountValidator();
		if(className.equals("com.citidev.salesforce.validators.modelvalidators.AllocationPayScheduleValidator"))
			return new AllocationPayScheduleValidator();
		return null;
	}

}
