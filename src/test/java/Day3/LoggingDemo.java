package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class LoggingDemo {

	@Test
	void testLogging() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.log().headers();
			//.log().cookies();
			//.log().body(); //Just want to print response body in console window
	}
}
