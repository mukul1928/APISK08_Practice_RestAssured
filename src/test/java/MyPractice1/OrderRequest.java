package MyPractice1;

import static io.restassured.RestAssured.given;

import Payload.OrderPayload;
import io.restassured.RestAssured;

public class OrderRequest {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1").body(OrderPayload.payloadOrder("ORD-987654")).when()
				.post("api/users").then().log().all().assertThat().statusCode(201)
				.extract().response().asString();
				System.out.println(Response);
	}
}
