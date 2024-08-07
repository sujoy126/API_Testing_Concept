package com.sample.crud.withBdd;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class SampleTestForDeleteTest {
	@Test
	public void deleteDataFromServer() {
		given()
		    .delete("http://106.51.90.215:8084/projects/TY_PROJ_11735")
	   .then()
	        .assertThat().statusCode(204)
	        .log().all();
		    
	}

}
