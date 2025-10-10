package AuthenticationEx;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class BasicAuthEx {
	public static void main(String[] args) {
		RestAssured.baseURI = "http://postman-echo.com";
		//Non-preemptive Basic Auth Ex: by default it is non-preemptive basic auth
		//Once you add .preemptive it will became a preemptive basic auth 
		String response = given().log().all().auth().preemptive().basic("postman", "password").when().get("basic-auth").then().log()
				.all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		
	}
}
