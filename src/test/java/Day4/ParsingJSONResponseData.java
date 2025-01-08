package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*What is JSON Parsing Response Data
 * By using JSONObject class we can parse JSON data
 * */
public class ParsingJSONResponseData {

	
	// To Validate Response We Used JSON Path
	//@Test
	void testJSONRespons() {
		
		given()
			.contentType("Content-Type.JSON")
		//data[5].email
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("data[5].email", equalTo("tracey.ramos@reqres.in"));
			// data[5].email this is the JSON Path
		
	}
	
	//Capturing response in variable and then validating Response body,header etc
	//@Test
	void testJSONResponseUsingVariable() {
		
	Response res =given()
				.contentType("Content-Type.JSON")
				
				.when()
				.get("https://reqres.in/api/users");
	
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	
	//For Body Validation
	
	String EmailAddress = res.jsonPath().get("data[5].email").toString();
	Assert.assertEquals(EmailAddress, "tracey.ramos@reqres.in");
		
	}
	
	
	//To validate the entire response body we have predefine class i.e JSONObjcet class
	//@Test
	void parsingResponseUsingJSONObject() {
		
		Response res = given()
							.contentType(ContentType.JSON)
							
						.when()
							.get("https://reqres.in/api/users");
		
		//Print all email
		
		JSONObject jo = new JSONObject(res.asString()); //converting response to JSON object
		
//		for(int i=0;i<jo.getJSONArray("data").length();i++) {
//			
//			String emails =jo.getJSONArray("data").getJSONObject(i).get("email").toString();
//			System.out.println(emails);
//		}
		
		//Print/validate Particular email
		
		boolean status = false;
		
		for(int i=0;i<jo.getJSONArray("data").length(); i++){
			
			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			
			if(email.equals("tracey.ramos@reqres.in")) {
				
				status=true;
				break;
			}
		} Assert.assertEquals(status, true);
		
	}
	
	@Test
	void parsingResponseUsingJSONObject1() {
		
		Response res = given()
							.contentType(ContentType.JSON)

					   .when()
							.get("http://localhost:3000/student");
		
		// Calculate the price of books
		
		JSONObject jo = new JSONObject(res.asString());
		
		double totalprice=0;
		
		for(int i =0; i<jo.getJSONArray("student").length(); i++) 
		{
			
			String price= jo.getJSONArray("student").getJSONObject(i).get("price").toString();
			totalprice = totalprice + Double.parseDouble(price);
		}
		System.out.println(totalprice);
		
		
		}
		
	}

