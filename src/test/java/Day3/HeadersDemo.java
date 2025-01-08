package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/*Validating Headers Value
 * Headers some Value changed but some values not changed
 * we validating not changing values like content-type,content-encoding,server etc
 * */
public class HeadersDemo {
	
	//@Test
	void testHeaders() {
		
		given()
			
		.when()
			.get("https://www.google.com/")
			
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
			.log().all();
		
	}
	
	// Get single header value from response
	//@Test
	void getSingleheader() {
		
		Response res=given()
				
				.when()
					.get("https://www.google.com/");
		
		
		//get single header
		
		String header_value = res.getHeader("Content-Type");
		System.out.println("Content-Type   "+header_value);
		
	}
	
	
	//get Multiple headers value from response
	@Test
	void getMultipleHeaders() {
		
		Response res =given()
				
				.when()
					.get("https://www.google.com/");
		
		//get mul headers
		//Headers - importing Headers
		Headers MulHeader = res.getHeaders();
		
		//here return type is Header.....need to import Header
		for(Header hd: MulHeader) {
			
			System.out.println(hd.getName()+"     "+hd.getValue());
		}
		
		}
		
		
	}
	


