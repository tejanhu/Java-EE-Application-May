package business.test;

import static org.junit.Assert.assertEquals;

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
import repositories.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
	public class AccountServiceTest {

		@InjectMocks
		private AccountService accountService;
		
		@Mock
		private AccountRepository repo;
		
		@Before
		public void setUp() {
			accountService.setRepo(repo);
		}
		
		private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"Jim\",\"lastName\":\"Douglas\",\"accountNumber\":\"1245\"}]";

		private static final String MOCK_OBJECT = "[{\"firstName\":\"Jim\",\"lastName\":\"Douglas\",\"accountNumber\":\"1245\"}]";
		
		public static final String MOCK_VALUE_DELETE_ACCOUNT_MESSAGE = Constants.DELETE_ACCOUNT_MESSAGE;
		public static final String MOCK_VALUE_CREATE_ACCOUNT_MESSAGE = Constants.CREATE_ACCOUNT_MESSAGE;
		public static final String MOCK_VALUE_UPDATE_ACCOUNT_MESSAGE = Constants.UPDATE_ACCOUNT_MESSAGE;
		public static final String MOCK_VALUE_ERROR_ACCOUNT_MESSAGE = Constants.ERROR_ACCOUNT_MESSAGE;
		
		@Test
		public void testCreateAccount() {
			Mockito.when(repo.createAnAccount("account info")).thenReturn("account successfully added");
			assertEquals("account successfully added", repo.createAnAccount("account info"));
			Mockito.verify(repo).createAnAccount("account info");
			Mockito.verify(repo, Mockito.never()).deleteAccount(1);
		}
		
		@Test
		public void testGetAllAccounts() {
			Mockito.when(repo.getAllAccounts()).thenReturn("accounts returned");
			assertEquals("accounts returned", accountService.getAllAccounts());
			Mockito.verify(repo).getAllAccounts();
			Mockito.verify(repo,Mockito.never()).deleteAccount(1);
		}
		
		@Test
		public void testUpdateAccount() {
			Mockito.when(repo.updateAnAccount(1, "account info")).thenReturn("account successfully updated");
			assertEquals("account successfully updated", repo.updateAnAccount(1, "account info"));
			Mockito.verify(repo).updateAnAccount(1, "account info");
			Mockito.verify(repo, Mockito.never()).createAnAccount("account info");
		}

		@Test
		public void testDeleteAccount() {
			Mockito.when(repo.deleteAccount(1)).thenReturn("account successfully deleted");
			assertEquals("account successfully deleted", accountService.deleteAccount(1));
			Mockito.verify(repo).deleteAccount(1);
			Mockito.verify(repo, Mockito.never()).createAnAccount("1");
		}
		
}
