package requestChanning;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployePOJO;
import pojoclass.utility.ProjectPojo;

public class Scenario2_AddEmployeeToProject {
	@Test
	public void sampleProject() {
	
	Random r = new Random();
	int rNum = r.nextInt(5000);	
	
  // API-1 :=> Add project in side server
	ProjectPojo pp = new ProjectPojo("HerryPorter_" + rNum, "Created", 0, "Sujoy");

Response rep1  =	given()
	              .contentType(ContentType.JSON)
	              .body(pp)
	           .when()
	              .post("http://49.249.28.218:8091/addProject");   
            rep1.then()
		          .assertThat().statusCode(201)
		          .log().all();
      // Capture project name from the response
            String prjtName = rep1.jsonPath().get("projectName");
            System.out.println(prjtName);
   
          //API-2 ==>: add employee to same project
              
      EmployePOJO empobj = new EmployePOJO("SDET", "12/07/2024","sujoy@gmail.com", "Sujoy_"+rNum, 3.8,
    		                                "1234567890", prjtName, "Automation","Sujoy_"+rNum);
                             given()
            		            .contentType(ContentType.JSON)
            		            .body(empobj)
            		        .when()
            		            .post("http://49.249.28.218:8091/employees")
                            .then()
                                .assertThat().statusCode(201)
                                .log().all();
            		        
                                 
                    
      
             
	}
}
