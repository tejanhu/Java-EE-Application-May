package interoperability.soap;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import entities.Account;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AccountSoapService {
	@WebMethod
	public Account getAccount(long id);
	
	@WebMethod
	public String getAllAccounts();
	
	@WebMethod
	public String createAccount(String account);
	
	@WebMethod
	public String updateAccount(long id, String originalAccount);
	
	@WebMethod
	public String deleteAccount(long id);
}
