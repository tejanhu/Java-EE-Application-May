package repositories;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import constants.Constants;
import entities.Account;
import entities.Transaction;
import util.JSONUtility;

@Transactional(REQUIRED)
public class TransactionRepository implements iTransactionRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;

	public String createTransaction(String transaction) {
		Transaction aTransaction = util.getObjectForJGson(transaction,Transaction.class);
		em.persist(aTransaction);
		return Constants.CREATE_MESSAGE;
	}

	public String updateTransaction(long id, String newTransaction) {
		Transaction updatedTransaction = util.getObjectForJGson(newTransaction, Transaction.class);
		Transaction transactionInDB = getTransaction(id);
		if(transactionInDB !=null) {
			transactionInDB = updatedTransaction;
			em.persist(transactionInDB);
		}
		return Constants.UPDATE_MESSAGE;
	}

	public String deleteTransaction(long id) {
		Transaction transactionInDB = getTransaction(id);
		if(transactionInDB!=null) {
			em.remove(transactionInDB);
		}
		return Constants.DELETE_MESSAGE;
	}
	@Transactional(SUPPORTS)
	public String getAllTransactions() {
		 return util.getJGsonForObject(em.createQuery("SELECT t FROM Transaction t").getResultList());
	}
	@Transactional(SUPPORTS)
	public Transaction getTransaction(long id) {
		return em.find(Transaction.class, id);
	}

	

}
