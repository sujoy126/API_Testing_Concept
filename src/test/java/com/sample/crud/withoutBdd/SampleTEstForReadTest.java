package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SampleTEstForReadTest {
	@Test
	public void getDataFromServer() {
		Response resp = RestAssured.get("http://106.51.90.215:8084/projects");
	//	System.out.println(resp.prettyPrint()); 
		  resp.then().assertThat().statusCode(200);
		  resp.then().log().all();
	}
	
	@Test
	public void postDataToServer() {
		
		
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sujoy");
		jobj.put("projectName", "Save_Time");
		jobj.put("status", "Created");
		jobj.put("projectSize", 10);
		
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jobj.toJSONString());
	
	Response rep = req.post("http://106.51.90.215:8084/addProject");
	rep.then().log().all();
	rep.then().assertThat().statusCode(201);
	}
	
	@Test
	public void putDataToServer() {
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "Save_Tree");
		jobj.put("createdBy", "Sujoy");
		jobj.put("status", "Update");
		jobj.put("projectSize", 10);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj.toJSONString());
		
		Response rep =  req.put("http://106.51.90.215:8084/projects/TY_PROJ_11729");
		rep.then().log().all();
		rep.then().assertThat().statusCode(200);
	}
	
	@Test
	public void patchDataToServer() {
		JSONObject jobj = new JSONObject();
		jobj.put("projectName", "Save_Life");
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj.toJSONString());
		
		Response rep =  req.patch("http://106.51.90.215:8084/project/TY_PROJ_11729");
		rep.then().log().all();
		rep.then().assertThat().statusCode(200);
	}
	
	@Test
	public void deletDataFromServer() {
		Response rep = RestAssured.delete("http://106.51.90.215:8084/projects/TY_PROJ_11729");
		rep.then().assertThat().statusCode(204);
		rep.then().log().all();
	}
	

}
