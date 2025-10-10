package MyPractice1;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class SendingComplexJson {
	public static void main(String[] args) {
		Map<String, Object> mp = new LinkedHashMap<String, Object>();
		mp.put("name", "harry");
		mp.put("job", "QA lead");
		mp.put("location", "Delhi");
		mp.put("salary", "50000");

		Map<String, Object> mp2 = new LinkedHashMap<String, Object>();
		mp2.put("name", "tom");
		mp2.put("job", "QA analyst");
		mp2.put("location", "Kolkata");
		mp2.put("salary", "80000");

		Map<String, Object> mp3 = new LinkedHashMap<String, Object>();
		mp3.put("name", "larry");
		mp3.put("job", "QA manager");
		mp3.put("location", "Chennai");
		mp3.put("salary", "90000");

		List<Map> li = new ArrayList<Map>();
		li.add(mp);
		li.add(mp2);
		li.add(mp3);

		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1").body(li)
				.when().post("api/users").then().log().all()
				.assertThat().statusCode(201)
				.extract().response().asString();
		System.out.println(Response);
	}
}
