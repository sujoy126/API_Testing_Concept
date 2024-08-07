package typesParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParamTest {
	@Test
	public void sampleTest() {
		given()
		    .queryParam("teamSize",10)
		    .when()
           //      .post("http://49.249.28.218:8091/project")		   
	//	          .get("http://49.249.28.218:8091/project?teamSize=10")
		          .get("http://49.249.28.218:8091/project")
		   .then()
		       .log().all();
		    
	}

}
