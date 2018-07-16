package business;

import entities.Account;

public interface iTransactionService {
	
	String createAnAccount(String account);
	
	String updateAnAccount(long id, String originalAccount);
	
	String deleteAccount(long id);

	String getAllAccounts();
	
    Account getAccount(long id);

}
