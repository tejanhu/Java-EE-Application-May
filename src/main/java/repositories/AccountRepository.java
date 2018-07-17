package repositories;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	
	@Inject
	private JSONUtility util;

	
	public String createAnAccount(String account) {
		Account aAccount = util.getObjectForJGson(account,Account.class);
		em.persist(aAccount);
		return Constants.CREATE_ACCOUNT_MESSAGE;
	}
	
	public String updateAnAccount(long id, String newAccount) {
		Account updatedAccount = util.getObjectForJGson(newAccount, Account.class);
		Account accountInDB = getAccount(id);
		if(accountInDB !=null) {
			accountInDB = updatedAccount;
			em.persist(accountInDB);
		}
		return Constants.UPDATE_ACCOUNT_MESSAGE;
	}
	
	public String deleteAccount(long id) {
		Account accountInDB = getAccount(id);
		if(accountInDB!=null) {
			em.remove(accountInDB);
		}
		return Constants.DELETE_ACCOUNT_MESSAGE;
	}

	@Transactional(SUPPORTS)	
	public String getAllAccounts() {
        return util.getJGsonForObject(em.createQuery("SELECT a FROM Account a").getResultList());
	}
	
	@Transactional(SUPPORTS)
    public Account getAccount(long id) {
        return em.find(Account.class, id);
    }




}
