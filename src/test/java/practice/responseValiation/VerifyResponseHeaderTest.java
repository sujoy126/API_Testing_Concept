package practice.responseValiation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseHeaderTest {
	@Test
	public void verifyHeader() {
		Response rep = given()
		                     .get("http://49.249.28.218:8091/projects");
		rep.then().log().all();
		
		rep.then().assertThat().statusLine("HTTP/1.1 200 ");
		
		rep.then().assertThat().statusCode(200);
		
		rep.then().assertThat().contentType(ContentType.JSON);
		
		rep.then().assertThat().header("Transfer-Encoding", "chunked");
	}

}
