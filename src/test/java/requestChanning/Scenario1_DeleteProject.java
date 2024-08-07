package requestChanning;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;
import static io.restassured.RestAssured.*;

public class Scenario1_DeleteProject {
	@Test
	public void postDataToServer() {
		Random r = new Random();
		int rNum = r.nextInt(5000);	
      //Add project in side server
		ProjectPojo pp = new ProjectPojo("HerryPorter_" + rNum, "Created", 100, "Sujoy");

	Response rep  =	given()
		              .contentType(ContentType.JSON)
		              .body(pp)
		           .when()
		              .post("http://106.51.90.215:8084/addProject");
		          
	            rep.then()
			          .assertThat().statusCode(201)
			         .log().all();
	            
	    // Capture project name from the response
	            String pjtId = rep.jsonPath().get("projectId");
	            System.out.println(pjtId);
	            
	   // api-2 : delete project 
	           given()
	                .delete("http://106.51.90.215:8084/projects/"+pjtId)
	           .then()
	                .log().all();
	}

}
