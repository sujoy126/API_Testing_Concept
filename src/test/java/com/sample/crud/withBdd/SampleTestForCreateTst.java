package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class SampleTestForCreateTst {
	@Test
	public void postDataToserver() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sujoy");
		jobj.put("projectName", "jaiShreeRam");
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);
		
		given()
		    .contentType(ContentType.JSON)
		    .body(jobj.toJSONString())
	    .when()
	        .post("http://106.51.90.215:8084/addProject")
	    .then()
	        .assertThat().statusCode(201)
	        .log().all();
		
	}

}
