package task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 {
 "name":[{"firstname": "D1"},
         {"lastname" : "D2"},
         {"phonenumber":[
                        {"home":123},
                        {"ofice":456}
                        ]
         }
        ]
}
 */

 class Name{
    public String firstname;
    public String lastname;
    public List<Phonenumber> phonenumber;
    
    public Name() {}
    
	public Name(String firstname, String lastname, List<Phonenumber> phNum) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phNum;	
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Phonenumber> getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(ArrayList<Phonenumber> phonenumber) {
		this.phonenumber = phonenumber;
	}   
}
 
  class Phonenumber{
	    public int home;
	    public int ofice;
	    
	    public Phonenumber() {}

		public Phonenumber(int home, int ofice) {
			super();
			this.home = home;
			this.ofice = ofice;
		}

		public int getHome() {
			return home;
		}

		public void setHome(int home) {
			this.home = home;
		}

		public int getOfice() {
			return ofice;
		}

		public void setOfice(int ofice) {
			this.ofice = ofice;
		}    
	}
  
  
  
  class Root{
	    public List<Name> name;
	    
	    public Root() {}

		public Root(List<Name> list) {
			super();
			this.name = list;
		}

		public List<Name> getName() {
			return name;
		}

		public void setName(ArrayList<Name> name) {
			this.name = name;
		}
	    	    
	}

public class NameAndDetails {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		List<Phonenumber> phNum = new ArrayList<>();
		phNum.add(new Phonenumber(123, 456));
		
		List<Name> list = new ArrayList<>();	
		list.add(new Name("D1","D2", phNum));
		
		Root r  = new Root(list);
		
		  ObjectMapper objM = new ObjectMapper();
          objM.writerWithDefaultPrettyPrinter().writeValue(new File("./Name_Det.json"), r);

		
		
		
	}

}
