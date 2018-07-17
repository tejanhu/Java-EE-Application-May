package business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import constants.Constants;
import entities.Account;
import repositories.AccountRepository;
import repositories.iAccountRepository;

public class AccountService implements iAccountService {
	
	private static final Logger LOGGER = Logger.getLogger(AccountChecker.class);
	
	@Inject
	private iAccountRepository repo;
	
	@Inject
	private AccountChecker accountChecker;

	public String createAnAccount(String account) {
		if( !accountChecker.validateFirstName(account) || !accountChecker.validateSurame(account) || !accountChecker.validateAccNo(account)) {
			LOGGER.info("In AccountService createAnAccount");
			return Constants.ERROR_ACCOUNT_MESSAGE;
			
		}
		else {
			LOGGER.info("In AccountService createAnAccount");
			return repo.createAnAccount(account);
		}
		
	}

	public String updateAnAccount(long id, String newAccount) {
		
		if( !accountChecker.validateFirstName(newAccount) || !accountChecker.validateSurame(newAccount) || !accountChecker.validateAccNo(newAccount)) {
			LOGGER.info("In AccountService updateAnAccount");
			return Constants.ERROR_ACCOUNT_MESSAGE;
		}
		else {
			LOGGER.info("In AccountService updateAnAccount");
			return repo.updateAnAccount(id,newAccount);
		}
		
		
	}

	public String deleteAccount(long id) {
		LOGGER.info("In AccountService deleteAccount");
		return repo.deleteAccount(id);
	}

	public String getAllAccounts() {
		LOGGER.info("In AccountService getAllAccounts");
		return repo.getAllAccounts();
	}

	public Account getAccount(long id) {
		LOGGER.info("In AccountService getAccount");
		return repo.getAccount(id);
	}
	
	public void setRepo(AccountRepository repo) {
		LOGGER.info("In AccountService setRepo ");
		this.repo = repo;
	}

}
