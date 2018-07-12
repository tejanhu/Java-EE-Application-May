package repositories;

import java.util.List;
import entities.Account;

public interface iAccountRepository {
	
	String createAnAccount(String account);
	
	String updateAnAccount(long id, String originalAccount);
	
	String deleteAccount(long id);

	String getAllAccounts();
	
    Account getAccount(long id);

}
