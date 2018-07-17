package interoperability.soap;

import javax.inject.Inject;
import javax.jws.WebService;
import org.apache.log4j.Logger;

import business.TransactionService;
	import entities.Transaction;

	@WebService(endpointInterface = "accountapp.interoperability.soap.TransactionSoapService")
	public class TransactionSoapndPoint implements TransactionSoapService {
		
		private static final Logger LOGGER = Logger.getLogger(TransactionSoapndPoint.class);

		@Inject
		private TransactionService transactionService;
		

		public Transaction getTransaction(long id){
			LOGGER.info("In TransactionRestEndPoint getTransaction");
			return transactionService.getTransaction(id);
		}
		

		public String getAllTransactions(){
			LOGGER.info("In TransactionRestEndPoint getAllTransactions");
			return transactionService.getAllTransactions();
		}
		

		public String createTransaction(String transaction){
			LOGGER.info("In TransactionRestEndPoint createTransaction");
			return transactionService.createTransaction(transaction);
		}
		

		public String updateTransaction(long id, String newTransaction){
			LOGGER.info("In TransactionRestEndPoint updateTransaction");
			return transactionService.updateTransaction(id, newTransaction);
		}
		

		public String deleteTransaction(long id){
			LOGGER.info("In TransactionRestEndPoint deleteTransaction");
			return transactionService.deleteTransaction(id);
		}
		

	
}
