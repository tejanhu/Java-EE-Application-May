package repositories;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import business.AccountService;
import constants.Constants;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import util.JSONUtility;
import entities.Account;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryTest {
	
	
	private JSONUtility util;
	
	@InjectMocks
	private AccountRepository repo;
	
	public static final String MOCK_VALUE_DELETE_ACCOUNT_MESSAGE = Constants.DELETE_ACCOUNT_MESSAGE;
	public static final String MOCK_VALUE_CREATE_ACCOUNT_MESSAGE = Constants.CREATE_ACCOUNT_MESSAGE;
	public static final String MOCK_VALUE_UPDATE_ACCOUNT_MESSAGE = Constants.UPDATE_ACCOUNT_MESSAGE;
	public static final String MOCK_VALUE_ERROR_ACCOUNT_MESSAGE = Constants.ERROR_ACCOUNT_MESSAGE;
	
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";
	
	private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"Jim\",\"lastName\":\"Douglas\",\"accountNumber\":\"1245\"}]";

	private static final String MOCK_OBJECT = "{\"firstName\":\"Jim\",\"lastName\":\"Douglas\",\"accountNumber\":\"1245\"}";
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query qry;
	
	@Before
	public void setup() {
		repo.setManager(em);
		util = new JSONUtility();
		repo.setUtil(util);
	}
	
	@Test
	public void createAnAccount() {	
		String response = repo.createAnAccount(MOCK_OBJECT);
		Assert.assertEquals(response, MOCK_VALUE_CREATE_ACCOUNT_MESSAGE);
	}
	
	@Test
	public void updateAnAccount() {
		
		String response = repo.updateAnAccount(2, MOCK_OBJECT);
		Assert.assertEquals(response, MOCK_VALUE_UPDATE_ACCOUNT_MESSAGE);
	}
	
	@Test
	public void deleteAccount() {
		
		String response = repo.deleteAccount(1);
		Assert.assertEquals(response, MOCK_VALUE_DELETE_ACCOUNT_MESSAGE);
	}

	@Test
	public void getAllAccounts() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(qry);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("Jim", "Douglas", "1245",null));
		Mockito.when(qry.getResultList()).thenReturn(accounts);
		assertEquals("[{\"id\":0,\"firstName\":\"Jim\",\"lastName\":\"Douglas\",\"accountNumber\":\"1245\"}]", repo.getAllAccounts());
	}
	
	@Test
    public void getAccount() {
		Account aAccount = repo.getAccount(1);
		Assert.assertEquals(aAccount, repo.getAccount(1));
    }




}
