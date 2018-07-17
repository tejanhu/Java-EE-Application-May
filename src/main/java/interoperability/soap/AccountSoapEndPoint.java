package interoperability.soap;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import business.AccountService;
import entities.Account;
import javax.jws.WebService;

@WebService(endpointInterface = "accountapp.interoperability.soap.AccountSoapService") 
public class AccountSoapEndPoint implements AccountSoapService {
	
	private static final Logger LOGGER = Logger.getLogger(AccountSoapEndPoint.class);

	@Inject
	private AccountService accountService;
	

	public Account getAccount(long id){
		LOGGER.info("In AccountRestEndPoint getAccount");
		return accountService.getAccount(id);
	}
	

	public String getAllAccounts(){
		LOGGER.info("In AccountRestEndPoint getAllAccounts");
		return accountService.getAllAccounts();
	}
	

	public String createAccount(String account){
		LOGGER.info("In AccountRestEndPoint createAccount");
		return accountService.createAnAccount(account);
	}
	

	public String updateAccount(long id, String originalAccount){
		LOGGER.info("In AccountRestEndPoint updateAccount");
		return accountService.updateAnAccount(id, originalAccount);
	}
	

	public String deleteAccount(long id){
		LOGGER.info("In AccountRestEndPoint deleteAccount");
		return accountService.deleteAccount(id);
	}
	

}
