package interoperability.soap;


import entities.Transaction;

public interface TransactionSoapService {

	public Transaction getTransaction(long id);
	

	public String getAllTransactions();
	

	public String createTransaction(String transaction);
	

	public String updateTransaction(long id, String newTransaction);
	

	public String deleteTransaction(long id);
	
}
