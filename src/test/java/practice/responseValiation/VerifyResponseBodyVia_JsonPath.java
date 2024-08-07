package practice.responseValiation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBodyVia_JsonPath {
	@Test
	public void bodyValidate() {
		Response rep = given()
		      .get("http://49.249.28.218:8091/projects-paginated");
		rep.then().log().all();
		
		       int data1 =  rep.jsonPath().get("numberOfElements");
		       System.out.println(data1);
		       
		       boolean data2 =  rep.jsonPath().get("pageable.sort.unsorted");
		       System.out.println(data2);
		       
		       String data3 = rep.jsonPath().get("content[1].projectId");
		       System.out.println(data3);
		       
        rep.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		rep.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		rep.then().assertThat().body("content[1].projectId", Matchers.equalTo("NH_PROJ_5322"));
		
		ArrayList<String> list = rep.jsonPath().get("content.projectId");
		System.out.println(list);
		
		
		
		
		
	}

}
