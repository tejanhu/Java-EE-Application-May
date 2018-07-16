package business;

import javax.inject.Inject;

import constants.Constants;
import entities.Account;
import repositories.iAccountRepository;

public class TransactionService implements iAccountService {
	
	@Inject
	private iAccountRepository repo;
	
	@Inject
	private AccountChecker accountChecker;

	public String createAnAccount(String account) {
		if( !accountChecker.validateFirstName(account) || !accountChecker.validateSurame(account) || !accountChecker.validateAccNo(account)) {
			return Constants.ERROR_MESSAGE;
		}
		else {
			return repo.createAnAccount(account);
		}
	}

	public String updateAnAccount(long id, String newAccount) {
		
		if( !accountChecker.validateFirstName(newAccount) || !accountChecker.validateSurame(newAccount) || !accountChecker.validateAccNo(newAccount)) {
			return Constants.ERROR_MESSAGE;
		}
		else {
			return repo.updateAnAccount(id,newAccount);
		}
		
		
	}

	public String deleteAccount(long id) {
		return repo.deleteAccount(id);
	}

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	public Account getAccount(long id) {
		return repo.getAccount(id);
	}

}
