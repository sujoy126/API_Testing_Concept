package practice.responseValiation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {
	@Test
	public void verifyTime() {

		Response rep = given().get("http://49.249.28.218:8091/projects");
		rep.then().log().all();

		long timeTaken = rep.time();
		long timeTakenMiliSec = rep.timeIn(TimeUnit.MILLISECONDS);

		System.out.println(timeTaken);
		System.out.println(timeTakenMiliSec);

		rep.then().assertThat().time(Matchers.lessThan(900l));

		rep.then().assertThat().time(Matchers.greaterThan(700l));

		rep.then().assertThat().time(Matchers.both(Matchers.lessThan(900l)).and(Matchers.greaterThan(700l)));
	}

}
