package Day5;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {

	@Test
	void singleFileUpload() {
		
		File file = new File("C:\\AutomationPractice\\Test1.txt");
		
		given()
			//We use multi-part for form-data uploading - interview question
			.multiPart("file", file)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.body("filename",equalTo("Test1.txt"))
			.log().all();
		
	}
	
	@Test
	void mulFileUpload() {
		
		File file1 = new File("C:\\AutomationPractice\\Test1.txt");
		File file2 = new File("C:\\AutomationPractice\\Test2.txt");
		
		given()
			.multiPart("files",file1)
			.multiPart("files", file2)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadmultipleFile")
		.then()
			.statusCode(200)
			.body("filename", equalTo("Test1.txt"))
			.body("filename", equalTo("Test2.txt"))
			.log().all();

		
	}
	@Test
	void fileDownload() {
		
		given()
		.when()
			.get("http://localhost:8080/downloadfile/Test1.txt")
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
