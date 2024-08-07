package practice.responseValiation;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class VerifyComplecJsonXpathTest {
	@Test
	public void sampleTest() {
		Response rep = given()
		     .get("http://49.249.28.218:8091/projects-paginated");
		
//		rep.then()
//		    .log().all();
		
		List<String> list = JsonPath.read(rep.asString(), "content[*].projectId");
		Object[] obj = list.toArray();
		for(Object objArray: obj) {
			System.out.println(objArray);
		}
	}

}
