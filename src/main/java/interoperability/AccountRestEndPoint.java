package interoperability;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import business.AccountService;
import entities.Account;

@Path("/account")
public class AccountRestEndPoint {

	@Inject
	private AccountService accountService;
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public Account getAccount(@PathParam("id") long id){
		return accountService.getAccount(id);
	}
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String createAccount(String account){
		return accountService.createAnAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") long id, String originalAccount){
		return accountService.updateAnAccount(id, originalAccount);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") long id){
		return accountService.deleteAccount(id);
	}
	

}
