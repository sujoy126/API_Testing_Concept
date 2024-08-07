package practice_Serialization_Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



/*
 * {
 *    "balanceDate": "2024-07-11",
 *    "accountBalance": [{
 *                         "acountNumber": 12345678909,
 *                         "country": "India",
 *                         "accountType": "seving"
 *                      }]
 * }
 */

class BalanceCheck{
	private String balanceDate;
	private AccountBalance accountBalance;
	
	public BalanceCheck() {}

	public BalanceCheck(String balanceDate, AccountBalance accountBalance) {
		super();
		this.balanceDate = balanceDate;
		this.accountBalance = accountBalance;
	}

	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}

	public AccountBalance getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(AccountBalance accountBalance) {
		this.accountBalance = accountBalance;
	}

	

	
		
}

class AccountBalance{
	long acountNumber;
	String country;
	String accountType;
	
	public AccountBalance() {}
	
	public AccountBalance(long acountNumber, String country, String accountType) {
		super();
		this.acountNumber = acountNumber;
		this.country = country;
		this.accountType = accountType;
	}

	public long getAcountNumber() {
		return acountNumber;
	}

	public void setAcountNumber(long acountNumber) {
		this.acountNumber = acountNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
		
}



public class RunBancAccPojoTest  {
	public static void main (String []args) throws StreamWriteException, DatabindException, IOException {
		
	  AccountBalance acb = new AccountBalance(12345678909l, "India","seving");
		BalanceCheck bc  = new BalanceCheck("2024-07-11", acb);
		
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./bank.json"), bc);
		
		System.out.println("=======closed========");
			
	}

}
