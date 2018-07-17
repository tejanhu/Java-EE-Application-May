package business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import constants.Constants;
import entities.Transaction;
import repositories.iTransactionRepository;

public class TransactionService implements iTransactionService {
	
	private static final Logger LOGGER = Logger.getLogger(TransactionService.class);
	
	@Inject
	private iTransactionRepository repo;
	
//	@Inject
//	private AccountChecker accountChecker;

	public String createTransaction(String transaction) {
//		if( !accountChecker.validateFirstName(account) || !accountChecker.validateSurame(account) || !accountChecker.validateAccNo(account)) {
//			return Constants.ERROR_MESSAGE;
//		}
//		else {
		LOGGER.info("In TransactionService createTransaction");
			return repo.createTransaction(transaction);
//		}
	}

	public String updateTransaction(long id, String newTransaction) {
		
//		if( !accountChecker.validateFirstName(newAccount) || !accountChecker.validateSurame(newAccount) || !accountChecker.validateAccNo(newAccount)) {
//			return Constants.ERROR_MESSAGE;
//		}
//		else {
		LOGGER.info("In TransactionService updateTransaction");
			return repo.updateTransaction(id,newTransaction);
//		}
		
		
	}

	public String deleteTransaction(long id) {
		LOGGER.info("In TransactionService deleteTransaction");
		return repo.deleteTransaction(id);
	}

	public String getAllTransactions() {
		LOGGER.info("In TransactionService getAllTransactions");
		return repo.getAllTransactions();
	}


	public Transaction getTransaction(long id) {
		LOGGER.info("In TransactionService getTransaction");
		return repo.getTransaction(id);
	}



}
