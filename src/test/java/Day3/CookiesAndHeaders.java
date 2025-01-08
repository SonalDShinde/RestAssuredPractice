package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
/* Sometimes we send the request and we get the cookies and headers as part of response
 */
public class CookiesAndHeaders {
	
	//@Test
	void testCookie() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
			
		.then()
			.cookie("AEC", "AZ6Zc-WKaoO27-HYJCFdG0iKcPnq5LnETqEyphuUhD4XqWtv7t-tYAANaw") 
			//Every time cookie value change if test get failed then our cookie generation working good...Test need to be failed
			.log().all();
			
	}
	
	//@Test
	void getSingleCookieInfo() {
		
		 Response res=given()
		
		.when()
			.get("https://www.google.com/");
		 
		 //Get a Single cookie info
		 
		 String value_cookie = res.getCookie("AEC");
		 System.out.println(value_cookie);
	}
	@Test
	void getAllCookiesInfo() {
		
		Response res =given()
		
		.when()
			.get("https://www.google.com/");
		
		//get information of all cookies
		//for that we writing simple java logic
		Map<String ,String> cookies_value = res.getCookies();
		
		//need to get keySet Means Name of key
		
		for(String k: cookies_value.keySet()) {
			String cookies_val= res.getCookie(k);
			System.out.println(k+"        : "+cookies_val);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
