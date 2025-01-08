package Day8;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class DeleteUser {
	@Test
	void deleteUser(ITestContext context) {
		
		String token="a4ff4c7fc5b8f22bd2c5cf960a9577f28c04a552dc0dc49c43ec4b793016f12a";
		//int  id = (int) context.getAttribute("user_id");
		int id =	(int) context.getSuite().getAttribute("user_id");
		
		given()
			.header("Authorization","Bearer "+token)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
		
		
		
	}
}
