package MyPractice1;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

import Payload.PayloadData;

public class PostExample1 {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1").body(PayloadData.addEmp("harry", "qalead")).when()
				.post("api/users").then().log().all().assertThat().statusCode(201)
				.header("content-type", "application/json").extract().response().asString();
		System.out.println(Response);
	}
}
