package com.sample.crud.withBdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestForReadTest {
	@Test
	public void getDataFromServer() {
		given()
		     .get("http://106.51.90.215:8084/projects")
	   .then()
	         .assertThat().statusCode(200)
	         .log().all();
		
	}

}
