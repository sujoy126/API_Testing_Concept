package task;

import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/*
 * [{
  "value":[
    {
      "user": [
    {
     "id": "123123",
     "value": "jerry"
    }
              ],
     "manager": [
    {
      "id": "234234",
      "value": "ENG"
    }
   ],
   "pinName": "PIN11111"
}],
  "itemConfigId": "itemConfig#123"
}]

 */

   
 class ItemValues {

   List<ValueUserManager> value;
   String itemConfigId;


    public ItemValues(List<ValueUserManager> value, String itemConfigId) {
	super();
	this.value = value;
	this.itemConfigId = itemConfigId;
}
	public void setValue(List<ValueUserManager> value) {
        this.value = value;
    }
    public List<ValueUserManager> getValue() {
        return value;
    }
    
    public void setItemConfigId(String itemConfigId) {
        this.itemConfigId = itemConfigId;
    }
    public String getItemConfigId() {
        return itemConfigId;
    }
    
}
 
  
 class UserINfo {

    String id;
   String value;


     public UserINfo(String id, String value) {
	super();
	this.id = id;
	this.value = value;
}
	public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }
     
     public void setValue(String value) {
         this.value = value;
     }
     public String getValue() {
         return value;
     }
     
 }
 
  class ManagerDetlils {

	   String id;
	   String value;


	    public ManagerDetlils(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	    }
		public void setId(String id) {
	        this.id = id;
	    }
	    public String getId() {
	        return id;
	    }
	    
	    public void setValue(String value) {
	        this.value = value;
	    }
	    public String getValue() {
	        return value;
	    }
	    
  }
  
 class ValueUserManager {

	   List<UserINfo> user;
	   List<ManagerDetlils> manager;
	   String pinName;


	    public ValueUserManager(List<UserINfo> user, List<ManagerDetlils> manager, String pinName) {
		super();
		this.user = user;
		this.manager = manager;
		this.pinName = pinName;
	}
		public void setUser(List<UserINfo> user) {
	        this.user = user;
	    }
	    public List<UserINfo> getUser() {
	        return user;
	    }
	    
	    public void setManager(List<ManagerDetlils> manager) {
	        this.manager = manager;
	    }
	    public List<ManagerDetlils> getManager() {
	        return manager;
	    }
	    
	    public void setPinName(String pinName) {
	        this.pinName = pinName;
	    }
	    public String getPinName() {
	        return pinName;
	    }
 }

public class UserManager {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
            // Create users
            UserINfo users = new UserINfo("123123", "jerry");
            List<UserINfo> userList = Arrays.asList(users);

            // Create managers
            ManagerDetlils managers = new ManagerDetlils("234234", "ENG");
            List<ManagerDetlils> managerList = Arrays.asList(managers);
            

            // Create values
            
             String pinName = "PIN11111";
            ValueUserManager vlu = new ValueUserManager(userList, managerList, pinName);
            
           //ItemValue Info
            List<ValueUserManager> valueList = Arrays.asList(vlu); 
            ItemValues managerInfo = new ItemValues(valueList, "itemConfig#123");

            // Create ObjectMapper instance
            ObjectMapper objM = new ObjectMapper();
            objM.writerWithDefaultPrettyPrinter().writeValue(new File("./manager1.json"), valueList);

            // Write object to JSON file
      //      objM.writeValue(new File("./manager1.json"), managerInfo);

            System.out.println("convert json file successfully!");
	}
}
