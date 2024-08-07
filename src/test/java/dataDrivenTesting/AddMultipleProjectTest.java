package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest {
	@Test(dataProvider = "getData")
	public void sampleProjectTest(String pName,String stus) {
		
	//	String pName = "laptop";
	//	String stus ="created";
		String reqBody="{\r\n"
				+ "  \"createdBy\": \"string\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+stus+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
	
		given()
		    .contentType(ContentType.JSON)
		    .body(reqBody)
		.when()
		    .post("http://49.249.28.218:8091/addProject")
		.then()
		    .log().all();		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objA  = new Object[3][2];
		
		objA[0][0] = "Laptop_4";
		objA[0][1] = "created";
		
		objA[1][0] = "Laptop_2";
		objA[1][1] = "created";
		
		objA[2][0] = "Laptop_3";
		objA[2][1] = "created";
		
		return objA;
	}

}
