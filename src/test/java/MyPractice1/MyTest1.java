package MyPractice1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class MyTest1 {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		Response res = given().log().all().when().get("api/users/2").then().log().all().assertThat().statusCode(200)
				.extract().response();
		String resString = res.asString();
		System.out.println(resString);
	}
}
