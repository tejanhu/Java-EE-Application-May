package business;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import entities.Account;
import util.JSONUtility;

public class AccountChecker implements iAccountChecker{
	
	private static final Logger LOGGER = Logger.getLogger(AccountChecker.class);
	
	@Inject
	private JSONUtility jsonUtil;
	
	public boolean validateAccNo(String account) {
		LOGGER.info("In AccountChecker validateAccNo");
		return jsonUtil.getObjectForJGson(account, Account.class).getAccountNumber().equals("9999")? false:true;
	}
	
	public boolean validateFirstName(String account) {
		LOGGER.info("In AccountChecker validateFirstName");
		return jsonUtil.getObjectForJGson(account, Account.class).getFirstName().equals("9999")? false:true;
	}
	
	public boolean validateSurame(String account) {
		LOGGER.info("In AccountChecker validateSurame");
		return jsonUtil.getObjectForJGson(account, Account.class).getLastName().equals("9999")? false:true;
	}
		

}
