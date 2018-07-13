package business;

import entities.Account;
import util.JSONUtility;

public class AccountChecker {
	
	private JSONUtility jsonUtil;
	
	public boolean getValidity(String account) {
		return jsonUtil.getObjectForJGson(account, Account.class).getAccountNumber().equals("9999")? false:true;
	}

}
