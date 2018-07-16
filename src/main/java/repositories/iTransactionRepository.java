package repositories;

import entities.Account;
import entities.Transaction;

public interface iTransactionRepository {

	String createTransaction(String transaction);
	
	String updateTransaction(long id, String originalAccount);
	
	String deleteTransaction(long id);

	String getAllTransactions();
	
    Transaction getTransaction(long id);
	
	
}
