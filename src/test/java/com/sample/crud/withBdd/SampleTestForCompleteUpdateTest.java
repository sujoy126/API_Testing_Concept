package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataFromServer() {
		
		/*
		 * "createdBy": "string",
  "projectName": "string",
  "status": "string",
  "teamSize": 0
		 * */
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "SujoyMondal");
		jobj.put("projectName", "HareKrishna");
		jobj.put("status", "Updated");
		jobj.put("teamSize", 20);
		
		given()
		   .contentType(ContentType.JSON)
		   .body(jobj.toJSONString())
		.when()
		   .put("http://106.51.90.215:8084/projects/TY_PROJ_11735")
		.then()
		  .assertThat().statusCode(200)
		  .log().all();
	}

}
