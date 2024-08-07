package practice.responseValiation;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ComplexXpathWithRegularExpressionTest {
	@Test
	public void GetData() {
		Response rep = given()
	                       .get("http://49.249.28.218:8091/projects-paginated");
		rep.then().log().all();
		
		List<String> list = JsonPath.read(rep.asString(), "content[*].[?(@.projectName=='Reliance1341')].projectId");
		String actActualId = list.get(0);	
		System.out.println(actActualId);
	//	System.out.println(list);
	}

}
