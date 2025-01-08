package Day7;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {
	
	//@Test
	void bareerToken() {
		
	
		String token = "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";
		
//		given()
//			.header("Authorization","Bearer"+token)
//		.when()
//			.get("https://github.com/SonalDShinde")
//		.then()
//			.statusCode(200)
//			.log().all();
		
		RestAssured.baseURI="https://github.com/SonalDShinde";
		RestAssured
			.given()
				.header("Authorization","Bearer"+token)
			.when()
				.get()
			.then()
				.statusCode(200)
				.log().all();
				
			
	}
	
	//@Test
	void oAuth1(){
		
		String consumerKey=""; 
		//etc
		
		
		
		given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
		
			}
	
	//@Test
	void oAuth2() {
		
		given()
			.auth().oauth2("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")
		.when()
			.get("https://github.com/SonalDShinde")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	@Test
	void testAPIKeyAuthentication() {
		
		//Method 1
//		given()
//			.queryParams("appid", "31443f392f50c35034f856093d55dc9b")
//			
//		.when()
//			.get("https://api.openweathermap.org/data/2.5/forecast?q=Delhi")
//			
//		.then()
//			.statusCode(200)
//			.log().all();
		
		//Method 2
		
		given()
			.queryParam("appid", "31443f392f50c35034f856093d55dc9b")
			.pathParam("path", "data/2.5/forecast")
			.queryParams("q", "Delhi")
		.when()
			.get("https://api.openweathermap.org/{path}")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
