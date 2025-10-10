package AuthenticationEx;
import static io.restassured.RestAssured.*;

import Payload.PayloadData;
import io.restassured.RestAssured;

public class BearerTokenAuthEx {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://gorest.co.in";
		
		String token = "Bearer 8c6b19bd19640fc01011df0b6371fe5da980740f4f1293951d874fcb718b287d";
		
		String Response = given().log().all().header("Authorization",token)
		.header("content-type","application/json")
		.body(PayloadData.goRestPayload())
		.when().post("public/v2/users")
		.then().log().all()
		.assertThat().statusCode(201)
		.extract().response().asString();
		System.out.println("The response is "+ Response);
	}
}
