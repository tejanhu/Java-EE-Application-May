package repositories;

import java.util.Collection;
import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import constants.Constants;


import util.JSONUtility;
import entities.Account;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements iAccountRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;	
	
	private HashMap<Long,Account> accountHashMap;
	
	private long ID;
	
	public AccountMapRepository() {
		this.accountHashMap = new HashMap<Long, Account>();
		ID = 1;
	}
	
	public String createAnAccount(String account) {
		ID++;
		Account aAccount = util.getObjectForJGson(account,Account.class);
		accountHashMap.put(ID, aAccount);
		return account;
	}
	
	public String updateAnAccount(long id, String originalAccount) {
		Account updatedAccount = util.getObjectForJGson(originalAccount, Account.class);
		accountHashMap.put(id,updatedAccount);
		return Constants.UPDATE_MESSAGE;
	}
	
	public String deleteAccount(long id) {
		accountHashMap.remove(id);
		return Constants.DELETE_MESSAGE;
	}

		
	public String getAllAccounts() {
        return util.getJGsonForObject(accountHashMap.values());
	}
	
	
    public Account getAccount(long id) {
        return accountHashMap.get(id);
    }

    

}
