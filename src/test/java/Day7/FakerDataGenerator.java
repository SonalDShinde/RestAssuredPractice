package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;


/* We add java faker dependency in pom.xml
 * faker dependency helps to generate random data for testing purpose in restAssuret Testing
 * we need to create faker class object for data creation */

public class FakerDataGenerator {

	@Test
	void testGenerateDummyData() {
		
		Faker faker = new Faker();
		
		String fullname = faker.name().fullName();
		String firstname = faker.name().firstName();
		
		String phone = faker.phoneNumber().cellPhone();
		String userName = faker.name().username();
		String password=faker.internet().password();
		String email =faker.internet().emailAddress();
		String safeemail = faker.internet().safeEmailAddress();
		
		System.out.println("fullname:  "+fullname);
		System.out.println("firstname:  "+firstname);
		System.out.println("phone:  "+phone);
		System.out.println("user:  "+userName);
		System.out.println("pass:  "+password);
		System.out.println("email:  "+email);
		System.out.println("safeemailaddress:  "+safeemail);
		
	}
}
