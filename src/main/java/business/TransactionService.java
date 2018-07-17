package business;

import javax.inject.Inject;

import constants.Constants;
import entities.Transaction;
import repositories.iTransactionRepository;

public class TransactionService implements iTransactionService {
	
	@Inject
	private iTransactionRepository repo;
	
//	@Inject
//	private AccountChecker accountChecker;

	public String createTransaction(String transaction) {
//		if( !accountChecker.validateFirstName(account) || !accountChecker.validateSurame(account) || !accountChecker.validateAccNo(account)) {
//			return Constants.ERROR_MESSAGE;
//		}
//		else {
			return repo.createTransaction(transaction);
//		}
	}

	public String updateTransaction(long id, String newTransaction) {
		
//		if( !accountChecker.validateFirstName(newAccount) || !accountChecker.validateSurame(newAccount) || !accountChecker.validateAccNo(newAccount)) {
//			return Constants.ERROR_MESSAGE;
//		}
//		else {
			return repo.updateTransaction(id,newTransaction);
//		}
		
		
	}

	public String deleteTransaction(long id) {
		return repo.deleteTransaction(id);
	}

	public String getAllTransactions() {
		return repo.getAllTransactions();
	}


	public Transaction getTransaction(long id) {
		return repo.getTransaction(id);
	}



}
