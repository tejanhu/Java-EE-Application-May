package interoperability;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import business.AccountService;
import entities.Account;

@Path("/account")
public class AccountRestEndPoint {
	
	private static final Logger LOGGER = Logger.getLogger(AccountRestEndPoint.class);

	@Inject
	private AccountService accountService;
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public Account getAccount(@PathParam("id") long id){
		LOGGER.info("In AccountRestEndPoint getAccount");
		return accountService.getAccount(id);
	}
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllAccounts(){
		LOGGER.info("In AccountRestEndPoint getAllAccounts");
		return accountService.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String createAccount(String account){
		LOGGER.info("In AccountRestEndPoint createAccount");
		return accountService.createAnAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") long id, String originalAccount){
		LOGGER.info("In AccountRestEndPoint updateAccount");
		return accountService.updateAnAccount(id, originalAccount);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") long id){
		LOGGER.info("In AccountRestEndPoint deleteAccount");
		return accountService.deleteAccount(id);
	}
	

}
