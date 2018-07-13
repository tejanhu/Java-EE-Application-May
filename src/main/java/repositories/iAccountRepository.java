package repositories;

import entities.Account;

public interface iAccountRepository {
	
	String createAnAccount(String account);
	
	String updateAnAccount(long id, String newAccount);
	
	String deleteAccount(long id);

	String getAllAccounts();
	
    Account getAccount(long id);

}
