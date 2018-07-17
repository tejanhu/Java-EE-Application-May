package interoperability.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import business.AccountService;
import constants.Constants;
import entities.Account;

@RunWith(MockitoJUnitRunner.class)
public class AccountRestEndPointTest {
	
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";
	
	
	public static final String MOCK_VALUE_DELETE_ACCOUNT_MESSAGE = Constants.DELETE_ACCOUNT_MESSAGE;
	public static final String MOCK_VALUE_CREATE_ACCOUNT_MESSAGE = Constants.CREATE_ACCOUNT_MESSAGE;
	public static final String MOCK_VALUE_UPDATE_ACCOUNT_MESSAGE = Constants.UPDATE_ACCOUNT_MESSAGE;
	public static final String MOCK_VALUE_ERROR_ACCOUNT_MESSAGE = Constants.ERROR_ACCOUNT_MESSAGE;
	
	
	@InjectMocks
	private AccountRestEndPoint restEndPoint;

	
	@Mock
	private AccountService accountService;
	
	
	
	@Before
	public void setup() {
		restEndPoint.setService(accountService);
	}

	@Test
	public void testGetAccount(){
		Account aAccount = accountService.getAccount(1);
		Assert.assertEquals(aAccount, restEndPoint.getAccount(1));
		Mockito.verify(accountService, Mockito.never()).deleteAccount(1);
	}
	

	@Test
	public void testGetAllAccounts(){
		Mockito.when(accountService.getAllAccounts()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndPoint.getAllAccounts());
	}
	
	@Test
	public void testCreateAccount(){
		restEndPoint.setService(accountService);
		Mockito.when(accountService.createAnAccount("testAccount")).thenReturn(MOCK_VALUE_CREATE_ACCOUNT_MESSAGE);
		Assert.assertEquals(MOCK_VALUE_CREATE_ACCOUNT_MESSAGE, restEndPoint.createAccount("testAccount"));
		Mockito.verify(accountService).createAnAccount("testAccount");
	}
	
	@Test
	public void testUpdateAccount(){
		Mockito.when(accountService.updateAnAccount(2, "testAccount")).thenReturn(MOCK_VALUE_UPDATE_ACCOUNT_MESSAGE);
		Assert.assertEquals(MOCK_VALUE_UPDATE_ACCOUNT_MESSAGE, restEndPoint.updateAccount(2, "testAccount"));
		Mockito.verify(accountService).updateAnAccount(2, "testAccount");
		Mockito.verify(accountService, Mockito.never()).deleteAccount(2);
	}
	
	@Test
	public void testDeleteAccount(){
		Mockito.when(accountService.deleteAccount(1)).thenReturn(MOCK_VALUE_DELETE_ACCOUNT_MESSAGE);
		Assert.assertEquals(MOCK_VALUE_DELETE_ACCOUNT_MESSAGE, restEndPoint.deleteAccount(1));
		Mockito.verify(accountService).deleteAccount(1);
	}
	

}
