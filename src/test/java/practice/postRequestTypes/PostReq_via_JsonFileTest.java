package practice.postRequestTypes;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReq_via_JsonFileTest {
	@Test
	public void postDataToServer() {
		File fiObj = new File("./teamData.JSON");
		
		given()
		     .contentType(ContentType.JSON)
		     .body(fiObj)
		.when()
		     .post("http://106.51.90.215:8084/addProject")
		 .then()
		     .assertThat().statusCode(201)
		     .log().all();
		
	}

}
