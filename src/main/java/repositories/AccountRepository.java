package repositories;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import constants.Constants;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import util.JSONUtility;
import entities.Account;



@Transactional(REQUIRED)
public class AccountRepository implements iAccountRepository{
	
	private static final Logger LOGGER = Logger.getLogger(AccountRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;

	
	public String createAnAccount(String account) {
		Account aAccount = util.getObjectForJGson(account,Account.class);
		em.persist(aAccount);
		LOGGER.info("In AccountRepository createAnAccount");
		return Constants.CREATE_ACCOUNT_MESSAGE;
	}
	
	public String updateAnAccount(long id, String newAccount) {
		Account updatedAccount = util.getObjectForJGson(newAccount, Account.class);
		Account accountInDB = getAccount(id);
		if(accountInDB !=null) {
			accountInDB = updatedAccount;
			accountInDB.setID(id);
			em.merge(accountInDB);
			LOGGER.info("In AccountRepository updateAnAccount");
		}
		LOGGER.info("In AccountRepository updateAnAccount");
		return Constants.UPDATE_ACCOUNT_MESSAGE;
	}
	
	public String deleteAccount(long id) {
		Account accountInDB = getAccount(id);
		if(accountInDB!=null) {
			em.remove(accountInDB);
			LOGGER.info("In AccountRepository deleteAccount");
		}
		LOGGER.info("In AccountRepository deleteAccount");
		return Constants.DELETE_ACCOUNT_MESSAGE;
	}

	@Transactional(SUPPORTS)	
	public String getAllAccounts() {
		LOGGER.info("In AccountRepository getAllAccounts");
        return util.getJGsonForObject(em.createQuery("SELECT a FROM Account a").getResultList());
	}
	
	@Transactional(SUPPORTS)
    public Account getAccount(long id) {
		LOGGER.info("In AccountRepository getAccount");
        return em.find(Account.class, id);
    }




}
