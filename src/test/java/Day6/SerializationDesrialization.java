package Day6;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*Use jackson API
 * Serialization - Converting POJO into JSON format -----> With the help of ObjectMapper Class and objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(std); Method
 * -Converting java object into JSON POJO-------->JSON
 *De-Serialization - Converting JSON into POJO -------> With the help of ObjectMapper Class and  objMapper.readValue(jsonData,StudentPOJO.class); Method */

public class SerializationDesrialization {

	//@Test
	void POJO2JSON() throws JsonProcessingException {
		
		StudentPOJO std = new StudentPOJO();
		
		std.setName("Sonal");
		String CoursArr[]= {"Java","SQL"};
		std.setCourses(CoursArr);
		
		ObjectMapper objmapper = new ObjectMapper();
		
		String jsonData =  objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(std); //Convert POJO to JSON
		System.out.println(jsonData);
	}
	
	@Test
	void JSON2POJO() throws JsonMappingException, JsonProcessingException {
		
		String jsonData = "{\r\n"
				+ "  \"name\" : \"Sonal\",\r\n"
				+ "  \"courses\" : [ \"Java\", \"SQL\" ]\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		
		StudentPOJO stdp = objMapper.readValue(jsonData,StudentPOJO.class); //Convert JSON to POJO
		
		System.out.println("Name :"+stdp.getName());
		System.out.println("Courses :"+stdp.getCourses()[0]);
		System.out.println("Courses :"+stdp.getCourses()[1]);
		
	}
	
}
 