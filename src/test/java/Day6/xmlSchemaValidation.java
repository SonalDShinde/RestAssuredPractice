package Day6;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class xmlSchemaValidation {

	@Test
	void validateXMLSchema() {
		
		given()
		.when()
			.get("http://samplerestapi.com/api/petslover")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("petlover.xsd"));
	}
}
