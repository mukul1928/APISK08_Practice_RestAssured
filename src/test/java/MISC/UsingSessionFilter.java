package MISC;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Payload.PayloadData;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class UsingSessionFilter {
	SessionFilter s;
	
	@BeforeTest
	public SessionFilter captureSessionId() {
		s = new SessionFilter();
		return s;
	}
	@Test
	public void myTest1() {
		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all()
				.relaxedHTTPSValidation().filter(s)
				.header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1").body(PayloadData.addEmp("harry", "qalead")).when()
				.post("api/users").then().log().all().assertThat().statusCode(201)
				.extract().response().asString();
		System.out.println(Response);
	}
	@Test
	public void myTest2() {
		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all()
				.relaxedHTTPSValidation().filter(s)
				
				.header("x-api-key", "reqres-free-v1")
				.when().delete("api/users/2")
				.then().log().all().assertThat().statusCode(204)
				.extract().response().asString();
		System.out.println(Response);
	}
	
}
