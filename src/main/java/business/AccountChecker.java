package business;

import javax.inject.Inject;

import entities.Account;
import util.JSONUtility;

public class AccountChecker implements iAccountChecker{
	
	@Inject
	private JSONUtility jsonUtil;
	
	public boolean validateAccNo(String account) {
		return jsonUtil.getObjectForJGson(account, Account.class).getAccountNumber().equals("9999")? false:true;
	}
	
	public boolean validateFirstName(String account) {
		return jsonUtil.getObjectForJGson(account, Account.class).getFirstName().equals("9999")? false:true;
	}
	
	public boolean validateSurame(String account) {
		return jsonUtil.getObjectForJGson(account, Account.class).getLastName().equals("9999")? false:true;
	}
		

}
