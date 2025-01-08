package Day8;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	void getUser(ITestContext  context) {
		
		//int id = (int) context.getAttribute("user_id"); //this should come from create use class
		
		int id =	(int) context.getSuite().getAttribute("user_id");

		
		String token = "a4ff4c7fc5b8f22bd2c5cf960a9577f28c04a552dc0dc49c43ec4b793016f12a";
		
		given()
			.header("Authorization", "Bearer "+token)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
}
