package Day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

/*here we use ITestContext Interface to make id available to other classes also
 * 
 * */

public class CreateUser {
	
	int id;

	@Test
	void createUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().safeEmailAddress());
		data.put("gender", "Female");
		data.put("status", "inactive");
		
		String token="a4ff4c7fc5b8f22bd2c5cf960a9577f28c04a552dc0dc49c43ec4b793016f12a";
		
		 id = 
		given()
					.header("Authorization","Bearer "+token)
					.contentType("application/json")
					.body(data.toString())
		
		.when()
					.post("https://gorest.co.in/public/v2/users")
					//.jsonPath().getInt("id");
					.jsonPath().getInt("id");
		
		System.out.println("Generated Id Is:  "+id);
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id",id); //for Suit level i.e testng1.xml file
		
	}
}
