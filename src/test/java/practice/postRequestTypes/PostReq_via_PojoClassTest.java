package practice.postRequestTypes;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

import java.util.Random;

import pojoclass.utility.ProjectPojo;

public class PostReq_via_PojoClassTest {
	@Test
	public void postDataToServer() {
		
		Random r = new Random();
		 int rndNumber = r.nextInt(5000);
		
		ProjectPojo pp = new ProjectPojo("MissionImposible_"+rndNumber, "created", 14, "Sujoy");
		
		given()
		     .contentType(ContentType.JSON)
		     .body(pp)
		.when()
		     .post("http://106.51.90.215:8084/addProject")
		.then()
		     .assertThat().statusCode(201)
		     .log().all();
		
		     
	}

}
