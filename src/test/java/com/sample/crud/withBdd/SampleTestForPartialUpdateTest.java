package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class SampleTestForPartialUpdateTest {
	@Test
	public void patchDataToServer() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sanjoy");
		
		given()
		    .contentType(ContentType.JSON)
		    .body(jobj.toString())
		.when()
		    .patch("http://106.51.90.215:8084/projects/TY_PROJ_11735")
		.then()
		    .assertThat().statusCode(200)
		    .log().all();
	}

}
