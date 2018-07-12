package repositories;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import constants.Constants;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import util.JSONUtility;
import entities.Account;


@Transactional(REQUIRED)
public class AccountRepository implements iAccountRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	private JSONUtility util;

	
	public String createAnAccount(String account) {
		Account aAccount = util.getObjectForJGson(account,Account.class);
		em.persist(aAccount);
		return Constants.CREATE_MESSAGE;
	}
	
	public String updateAnAccount(long id, String originalAccount) {
		Account updatedAccount = util.getObjectForJGson(originalAccount, Account.class);
		Account accountInDB = getAccount(id);
		if(originalAccount !=null) {
			accountInDB = updatedAccount;
			em.persist(accountInDB);
		}
		return Constants.UPDATE_MESSAGE;
	}
	
	public String deleteAccount(long id) {
		Account accountInDB = getAccount(id);
		if(accountInDB!=null) {
			em.remove(accountInDB);
		}
		return Constants.DELETE_MESSAGE;
	}

	@Transactional(SUPPORTS)	
	public String getAllAccounts() {
		Query qry = em.createQuery("SELECT * FROM Account");
		Collection <Account> accounts = (Collection<Account>) qry.getResultList();
        return util.getJGsonForObject(accounts);
	}
	
	@Transactional(SUPPORTS)
    public Account getAccount(long id) {
        return em.find(Account.class, id);
    }




}
