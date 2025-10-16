package MISC;
import static io.restassured.RestAssured.*;

import Payload.PayloadData;
import io.restassured.RestAssured;

public class HandlingXMLData {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://petstore.swagger.io";
		String Response = given().log().all().header("content-type","application/xml")
		.body(PayloadData.getPayloadData(5))
		.when().post("v2/pet")
		.then().log().all()
		.extract().response().asString();
		System.out.println("Response is "+ Response);
	}
}
