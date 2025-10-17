package RequestResponseSpecification;

import Payload.PayloadData;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResponseSpecification {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.setContentType(ContentType.JSON)
				.build();
		
		RequestSpecification respec = given().log().all().spec(req);
		
		ResponseSpecification res = (ResponseSpecification) new ResponseSpecBuilder()
		.expectStatusCode(201).build();
	
		String Response = respec.header("x-api-key","reqres-free-v1").body(PayloadData.addEmp("Harry", "Lead QA"))
		.when().post("api/users").then().log().all().spec(res).extract().response().asString();
		
		System.out.println(Response);
	}
}
