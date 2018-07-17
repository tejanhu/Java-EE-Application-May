package repositories;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import constants.Constants;
import entities.Transaction;
import util.JSONUtility;

@Transactional(REQUIRED)
public class TransactionRepository implements iTransactionRepository{
	
	private static final Logger LOGGER = Logger.getLogger(TransactionRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;

	public String createTransaction(String transaction) {
		Transaction aTransaction = util.getObjectForJGson(transaction,Transaction.class);
		em.persist(aTransaction);
		LOGGER.info("In TransactionRepository createTransaction");
		return Constants.CREATE_TRANSACTION_MESSAGE;
	}

	public String updateTransaction(long id, String newTransaction) {
		Transaction updatedTransaction = util.getObjectForJGson(newTransaction, Transaction.class);
		Transaction transactionInDB = getTransaction(id);
		if(transactionInDB !=null) {
			transactionInDB = updatedTransaction;
			em.persist(transactionInDB);
			LOGGER.info("In TransactionRepository updateTransaction");
		}
		LOGGER.info("In TransactionRepository updateTransaction");
		return Constants.UPDATE_TRANSACTION_MESSAGE;
	}

	public String deleteTransaction(long id) {
		Transaction transactionInDB = getTransaction(id);
		if(transactionInDB!=null) {
			em.remove(transactionInDB);
			LOGGER.info("In TransactionRepository deleteTransaction");
		}
		LOGGER.info("In TransactionRepository deleteTransaction");
		return Constants.DELETE_TRANSACTION_MESSAGE;
	}
	@Transactional(SUPPORTS)
	public String getAllTransactions() {
		LOGGER.info("In TransactionRepository getAllTransactions");
		 return util.getJGsonForObject(em.createQuery("SELECT t FROM Transaction t").getResultList());
	}
	@Transactional(SUPPORTS)
	public Transaction getTransaction(long id) {
		LOGGER.info("In TransactionRepository getTransaction");
		return em.find(Transaction.class, id);
	}

	

}
