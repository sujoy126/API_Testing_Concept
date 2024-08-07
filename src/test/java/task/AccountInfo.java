package task;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



   
 class Bank {

	    private String balanceDate;
	    private AccountBalance accountBalance;

	    // Constructor
	    public Bank() {
	    }

	    public Bank(String balanceDate, AccountBalance accountBalance) {
	        this.balanceDate = balanceDate;
	        this.accountBalance = accountBalance;
	    }

	    // Getters and Setters
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
 
 
    
  class AccountBalance {

     long acNum;
     String country;
     String AcType;
	public AccountBalance(long acNum, String country, String acType) {
		super();
		this.acNum = acNum;
		this.country = country;
		AcType = acType;
	}
	public long getAcNum() {
		return acNum;
	}
	public void setAcNum(long acNum) {
		this.acNum = acNum;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAcType() {
		return AcType;
	}
	public void setAcType(String acType) {
		AcType = acType;
	}


     
 }


public class AccountInfo {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
            // Create an instance of AccountBalance
            AccountBalance ab = new AccountBalance(1234567898L, "India", "Savings");

            // Create an instance of Bank with balanceDate and AccountBalance
            Bank bnk = new Bank("2024-07-11", ab);

            // Create ObjectMapper instance
            ObjectMapper objM = new ObjectMapper();
//            
//            String jsonString = objM.writeValueAsString(bnk);
//            System.out.println("Serialized JSON: " + jsonString);
    		objM.writerWithDefaultPrettyPrinter().writeValue(new File("./account.json"), bnk);

            System.out.println("========close=========");

            

            
	}

}
