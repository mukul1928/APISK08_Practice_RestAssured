package MISC;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.RestAssured;

public class FileAsInput {
	
	public static void main(String[] args) {
		File E = new File("E:\\My Test1.txt");
		File E1 = new File("E:\\\\My Test1.txt");
		RestAssured.baseURI = "https://httpbin.org";
		String Response = given().log().all()
				.header("Content-type","multipart/form-data")
				.multiPart("File",E)
				.multiPart("File",E1)
				.when().post()
				.then().log().all().extract().response()
				.asString();
		System.out.println(Response);
				
	}
}
