package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import Day2.StudentPOJO;
import io.restassured.RestAssured;

/*Creating Post request in different ways
 * 1.HashMap
 * 2.Using (org.json) by creating jsonobject
 * 3.Using POJO(Plain old java object)
 * 4.Using external json file
 * */
public class PostRequest {

	//@Test
	void validataHashMap() {
		
		HashMap data = new HashMap();
		data.put("name", "Omkar");
		
		String courseArr[]= {"Java","Web Tech"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/student")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Omkar"))
			.body("courses[0]", equalTo("Java"))
			.body("courses[1]", equalTo("Web Tech"))
			//.header("Content-Type","application/json; charset=utf-8")
			.log().all();
			
	}
	
	// 2 Using org.json dependence in pom.xml
	//@Test
	void addDataJsonObject() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Rekha");
		
		String courseArray[]= {"Database","Linux Operating System"};
		data.put("courses", courseArray);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/student")
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Rekha"))
			.body("courses[0]", equalTo("Database"))
			.body("courses[1]",equalTo("Linux Operating System"))
			.log().all();
			
	}
	
	//Passing Post Request Data by using POJO class
	//@Test
	void postDataByPojo() {
		
		StudentPOJO data = new StudentPOJO();
		data.setName("Dnyaneshwar");
		String CArray[]= {"c","c++"};
		data.setCourses(CArray);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/student")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Dnyaneshwar"))
			.log().all();
			
		
	}
	
	//Passing Post data by using External Json File => Std.json
	@Test
	void postByJSONFile() throws FileNotFoundException {
		
		File file = new File(".\\Std.json");
		/*FileReader filereader = new FileReader(file);
		JSONTokener jst = new JSONTokener(filereader);
		JSONObject data = new JSONObject(jst);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/student")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Anurag Shinde"))
			.body("courses[0]", equalTo("java"))
			.body("courses[1]", equalTo("sql"))
			.log().all();*/
		
		RestAssured.baseURI="http://localhost:3000/student";
		
		RestAssured
			.given()
				.contentType("application/json")
			.when()
				.post()
			.then()
				.statusCode(201);
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
