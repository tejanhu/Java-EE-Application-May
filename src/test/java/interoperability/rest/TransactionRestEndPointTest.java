package interoperability.rest;




	import org.junit.Assert;
	import org.junit.Before;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.runners.MockitoJUnitRunner;

import business.TransactionService;
import constants.Constants;
import entities.Transaction;

	@RunWith(MockitoJUnitRunner.class)
	public class TransactionRestEndPointTest {
				
		private static final String MOCK_VALUE2 = "test_value_2";

		private static final String MOCK_VALUE = "test_value";

		
		public static final String MOCK_VALUE_DELETE_TRANSACTION_MESSAGE = Constants.DELETE_TRANSACTION_MESSAGE;
		public static final String MOCK_VALUE_CREATE_TRANSACTION_MESSAGE = Constants.CREATE_TRANSACTION_MESSAGE;
		public static final String MOCK_VALUE_UPDATE_TRANSACTION_MESSAGE = Constants.UPDATE_TRANSACTION_MESSAGE;
		public static final String MOCK_VALUE_ERROR_TRANSACTION_MESSAGE = Constants.ERROR_TRANSACTION_MESSAGE;
		
		
		@InjectMocks
		private TransactionRestEndPoint restEndPoint;

		
		@Mock
		private TransactionService transactionService;

		
		@Before
		public void setup() {
			restEndPoint.setService(transactionService);
		}
		
		
		@Test
		public void testGetTransaction(){
			Transaction aTransaction = transactionService.getTransaction(1);
			Assert.assertEquals(aTransaction, restEndPoint.getTransaction(1));
			Mockito.verify(transactionService, Mockito.never()).deleteTransaction(1);
		}
		

		@Test
		public void testGetAllTransactions(){
			Mockito.when(transactionService.getAllTransactions()).thenReturn(MOCK_VALUE);
			Assert.assertEquals(MOCK_VALUE, restEndPoint.getAllTransactions());
		}
		
		@Test
		public void testCreateTransaction(){
			Mockito.when(transactionService.createTransaction("testTransaction")).thenReturn(MOCK_VALUE_CREATE_TRANSACTION_MESSAGE);
			Assert.assertEquals(MOCK_VALUE_CREATE_TRANSACTION_MESSAGE, restEndPoint.createTransaction("testTransaction"));
			Mockito.verify(transactionService).createTransaction("testTransaction");
		}
		
		@Test
		public void testUpdateTransaction(){
			Mockito.when(transactionService.updateTransaction(1, "testTransaction")).thenReturn(MOCK_VALUE_UPDATE_TRANSACTION_MESSAGE);
			Assert.assertEquals(MOCK_VALUE_UPDATE_TRANSACTION_MESSAGE, restEndPoint.updateTransaction(1, "testTransaction"));
			Mockito.verify(transactionService).updateTransaction(1, "testTransaction");
			Mockito.verify(transactionService, Mockito.never()).deleteTransaction(1);
		}
		
		@Test
		public void testDeleteTransaction(){
			Mockito.when(transactionService.deleteTransaction(1)).thenReturn(MOCK_VALUE_DELETE_TRANSACTION_MESSAGE);
			Assert.assertEquals(MOCK_VALUE_DELETE_TRANSACTION_MESSAGE, restEndPoint.deleteTransaction(1));
			Mockito.verify(transactionService).deleteTransaction(1);
		}
		

	
}
