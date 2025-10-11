package AuthenticationEx;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class APIKeyAuthenticationEx {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.openweathermap.org";
		String Response = given().log().all().queryParam("q", "London,UK")
				.queryParam("appid", "3013da786b96e837487d9a1e2d858729").when().get("data/2.5/weather").then().log()
				.all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Response);
	}
}
