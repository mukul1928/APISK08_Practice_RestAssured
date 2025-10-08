package MyPractice1;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class GetWithQueryParam {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";

		String Response = given().log().all().queryParam("page", 2).when().get("api/users").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		System.out.println(Response);
	}
}
