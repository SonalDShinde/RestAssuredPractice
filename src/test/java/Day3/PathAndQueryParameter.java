package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

/*https://reqres.in/api/users?page=2
 * https://reqres.in/ - Server / Domain
 * api/ - Path
 * users - Path ...
 * After question mark whatever there is it is query
 * page=2 - Query
 */
public class PathAndQueryParameter {
	
	 @Test
	 void testQueryPathParam(){
		
		 given()
		 	.pathParam("MyPath", "users")
		 	.queryParam("page", "2")
		 	.queryParam("id", "1")
		 	
		 .when()
		 	.get("https://reqres.in/api/{MyPath}")
		 	
		 .then()
		 	.statusCode(200)
		 	.log().all();
		
	}
	 
	 
	
	
}
