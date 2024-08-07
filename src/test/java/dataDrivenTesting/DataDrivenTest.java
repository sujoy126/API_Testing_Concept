package dataDrivenTesting;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenTest {
	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String stus) {
		String reqbody ="{\r\n"
				+ "  \"createdBy\": \"Sujoy\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+stus+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
		   .contentType(ContentType.JSON)
		   .body(reqbody)
		.when()
		    .post("http://49.249.28.218:8091/addProject")
		.then()
		    .log().all();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException, Throwable{
		ExcelUtility eLib = new ExcelUtility();
		int count = eLib.getRowCount("servivel");
		
		Object[][] objAr =new Object[count][2];
		for(int i=0; i<count; i++) {
		 objAr[i][0] = eLib.getDataFromExcel("servivel", i+1, 0);
		 objAr[i][1] = eLib.getDataFromExcel("servivel", i+1, 1);
		}
		return objAr;
	}

}
