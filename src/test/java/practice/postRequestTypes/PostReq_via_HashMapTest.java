package practice.postRequestTypes;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReq_via_HashMapTest {
	@Test
	public void postDataToServer() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("createdBy", "Sujoy");
		map.put("projectName", "jaiShreeRam");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		given()
		     .contentType(ContentType.JSON)
		     .body(map)
		.when()
		     .post("http://106.51.90.215:8084/addProject")
		.then()
		     .assertThat().statusCode(201)
		     .log().all();
	}
	

}
