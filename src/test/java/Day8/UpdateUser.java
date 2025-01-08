package Day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class UpdateUser {

	@Test
	void updateUser(ITestContext context) {
		
		
		
		Faker fajer = new Faker();
		
		JSONObject data = new JSONObject();
		data.putOnce("name", fajer.name().firstName());
		data.put("email", fajer.internet().emailAddress());
		data.put("gender", "Male");
		data.put("status", "Active");
		
		String token="a4ff4c7fc5b8f22bd2c5cf960a9577f28c04a552dc0dc49c43ec4b793016f12a";
		
		//int  id = (int) context.getAttribute("user_id");
		int id =	(int) context.getSuite().getAttribute("user_id");

		given()
					.header("Authorization","Bearer "+token)
					.contentType("application/json")
					.body(data.toString())
					.pathParam("id", id)
		
		.when()
					.post("https://gorest.co.in/public/v2/users/{id}")
		.then()
					.statusCode(201);
			
		
		
		
		
	}
}
