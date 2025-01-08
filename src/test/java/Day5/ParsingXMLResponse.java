package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ParsingXMLResponse {
	
	//@Test
	void testXMLResponse() {
		
		
		//Approach 1
		/*
		given()
		
		.when()
		.get("http://samplerestapi.com/api/petslover")
		
		.then()
		.statusCode(200)
		.header("Content-Type","application/xml; charset=utf-8")
		.body("PetsLoverInformationResponse.page", equalTo("1"))
		//.body("PetsLoverInformationResponse.travelers.PetsloverInformation[0].email", equalTo("mike5644my@gmail.com"));
		.log().all();
		*/
		
		//Approach 2
		Response res = given()
		
			          .when()
			          .get("http://samplerestapi.com/api/petslover");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		
		String page = res.xmlPath().get("PetsLoverInformationResponse.page").toString();
		Assert.assertEquals(page, "1");
		
		String email =res.xmlPath().get("PetsLoverInformationResponse.travelers.PetsloverInformation[0].email").toString();
		Assert.assertEquals(email, "mike5644my@gmail.com");
	}
	
	@Test
	void xmlResponseBody() {
		
		Response res=given()
				
				.when()
				.get("http://samplerestapi.com/api/petslover");
		
		
		XmlPath xmlobj = new XmlPath(res.asString());
		
		//verify List(total no of pet lovers) of pet lovers
		
		List<String> Travelers_No = xmlobj.getList("PetsLoverInformationResponse.travelers.PetsloverInformation");
		Assert.assertEquals(Travelers_No.size(), 10);
		
		//get all pet lovers name
		List<String> name = xmlobj.getList("PetsLoverInformationResponse.travelers.PetsloverInformation.name");
		
		for(String names: name)
		{
			//System.out.println(names);
		}
		
		//verify particular email of pet lover
		List<String> email = xmlobj.getList("PetsLoverInformationResponse.travelers.PetsloverInformation.email");
		boolean status = false;

		for(String verifyNames :email ) {
			
			if(verifyNames.equals("mike5644my@gmail.com"))
			{
			status=true;
			break;
			}
		}
		Assert.assertEquals(status, true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
