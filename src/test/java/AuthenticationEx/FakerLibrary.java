package AuthenticationEx;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import com.github.javafaker.Faker;

import Payload.PayloadData;
import io.restassured.RestAssured;

public class FakerLibrary {
	public static void main(String[] args) {
		Faker fake = new Faker();
		String name = fake.name().fullName();
		String email = fake.internet().emailAddress();
		String phone = fake.phoneNumber().cellPhone();
		long salary = fake.number().randomNumber();
		
		Map<String, Object> mp = new LinkedHashMap<String, Object>();
		mp.put("name", name);
		mp.put("emailAddress", email);
		mp.put("contact no", phone);
		mp.put("salary", salary);

		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all()
				.header("content-type","application/json")
				.header("x-api-key", "reqres-free-v1")
				.body(mp)
				.when().post("api/users")
				.then().log().all()
				.assertThat().statusCode(201)
				.extract().response().asString();
		System.out.println(Response);
	}
}
