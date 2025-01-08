package Day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
/* .given() prerequisites  
 *  	content type, set cookies, add auth, add param, set header info etc
 * .when() Request
 * 		Get, Post, Delete, put
 * .then() validation
 * 		validate status code, Extract response, extract headers cookies and response body
 * 
 * */
public class HttpRequests {
	
	int id ;

	@Test(priority = 1)
	void getListOfUsers() {
		
		 given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200) //validating status code
			.body("page",equalTo(2))  //checking response body
			.log().all(); //To print output on console window
	}
	
	@Test(priority = 2)
	void postUser() {
		
		HashMap data = new HashMap();
		data.put("name", "pavan");
		data.put("job", "Trainer");
		
		id=given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users") 
			.jsonPath().getInt("id");   //we are returning id here for next updateUser() method....using this we are capturing the id of created user to update and delete user 
		
		/*.then()
			.statusCode(201)
			.log().all();*/
	}
	
	@Test(priority = 3,dependsOnMethods = {"postUser"})
	
	void updateUser() {
		
		HashMap data = new HashMap();
		data.put("name", "Anurag");
		data.put("job","Advocate");
		
			given()
				.contentType("application/json")
				.body(data)
				
			.when()
				.put("https://reqres.in/api/users/"+id)
			
			.then()
				.statusCode(200)
				.log().all();
	}
	
	@Test(priority = 4 ,dependsOnMethods = {"postUser"})
	void deleteUser() {
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
	
	
	
	
	
	
}
