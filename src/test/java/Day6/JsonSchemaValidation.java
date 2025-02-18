package Day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;


public class JsonSchemaValidation {

	@Test
	void jsonSchemaValidation() {
		
		given()
		
		.when()
			.get("http://localhost:3000/student")
			
		.then()
			.statusCode(200)
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("studentJSONSchema.json"));
		
	}
}
