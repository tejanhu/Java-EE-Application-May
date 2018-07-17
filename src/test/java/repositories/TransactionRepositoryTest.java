package repositories;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import constants.Constants;
import entities.Account;
import entities.Transaction;
import interoperability.rest.TransactionRestEndPoint;
import util.JSONUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
	
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	

	
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";
	
	public static final String MOCK_VALUE_DELETE_TRANSACTION_MESSAGE = Constants.DELETE_TRANSACTION_MESSAGE;
	public static final String MOCK_VALUE_CREATE_TRANSACTION_MESSAGE = Constants.CREATE_TRANSACTION_MESSAGE;
	public static final String MOCK_VALUE_UPDATE_TRANSACTION_MESSAGE = Constants.UPDATE_TRANSACTION_MESSAGE;
	public static final String MOCK_VALUE_ERROR_TRANSACTION_MESSAGE = Constants.ERROR_TRANSACTION_MESSAGE;
	
	@InjectMocks
	private TransactionRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query qry;
	
	@Inject
	private JSONUtility util;

	private static final String MOCK_DATA_ARRAY = "[{\"id\":\"1\",\"name\":\"Doe\"}]";

	private static final String MOCK_OBJECT = "[{\"id\":\"1\",\"name\":\"Doe\"}]";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtility();
		repo.setUtil(util);
	}

//	@Test
//	public void testGetAllTransactions(){
//		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(qry);
//		List<Transaction> transactions = new ArrayList<Transaction>();
//		transactions.add(new Transaction());
//		Mockito.when(qry.getResultList()).thenReturn(transactions);
//		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllTransactions());
//	}
	
//	@Test
//	public void testCreateTransaction(){
//		String response = repo.createTransaction(MOCK_OBJECT);
//		Assert.assertEquals(response, MOCK_VALUE_CREATE_TRANSACTION_MESSAGE);
//	}
	
//	@Test
//	public void testUpdateTransaction(){
//		String response = repo.updateTransaction(1, MOCK_OBJECT);
//		Assert.assertEquals(response, MOCK_VALUE_UPDATE_TRANSACTION_MESSAGE);
//	}
	
	@Test
	public void testDeleteTransaction(){
		String response = repo.deleteTransaction(1);
		Assert.assertEquals(response, MOCK_VALUE_DELETE_TRANSACTION_MESSAGE);
	}
	
	@Test
	public void testGetTransaction(){
		Transaction aTransaction = repo.getTransaction(1);
		Assert.assertEquals(aTransaction, repo.getTransaction(1));
	}

	

}
