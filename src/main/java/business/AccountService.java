package business;

import javax.inject.Inject;

import constants.Constants;
import entities.Account;
import repositories.iAccountRepository;

public class AccountService implements iAccountService {
	
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

	public String updateAnAccount(long id, String originalAccount) {
		return repo.updateAnAccount(id,originalAccount);
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
