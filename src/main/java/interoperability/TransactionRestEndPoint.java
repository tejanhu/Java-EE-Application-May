package interoperability;


	import javax.inject.Inject;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import business.TransactionService;
	import entities.Transaction;

	@Path("/transaction")
	public class TransactionRestEndPoint {

		@Inject
		private TransactionService transactionService;
		
		@Path("/json/{id}")
		@GET
		@Produces({"application/json"})
		public Transaction getTransaction(@PathParam("id") long id){
			return transactionService.getTransaction(id);
		}
		
		@Path("/json")
		@GET
		@Produces({"application/json"})
		public String getAllTransactions(){
			return transactionService.getAllTransactions();
		}
		
		@Path("/json")
		@POST
		@Produces({"application/json"})
		public String createTransaction(String transaction){
			return transactionService.createTransaction(transaction);
		}
		
		@Path("/json/{id}")
		@PUT
		@Produces({"application/json"})
		public String updateTransaction(@PathParam("id") long id, String newTransaction){
			return transactionService.updateTransaction(id, newTransaction);
		}
		
		@Path("/json/{id}")
		@DELETE
		@Produces({"application/json"})
		public String deleteTransaction(@PathParam("id") long id){
			return transactionService.deleteTransaction(id);
		}
		

	
}
