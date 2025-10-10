package AuthenticationEx;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class DigestAuthEx {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://httpbin.org/digest-auth";
		String response = given().log().all().auth().digest("chandan", "chandan").when()
				.get("/undefined/chandan/chandan").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
		System.out.println(response);
	}
}
