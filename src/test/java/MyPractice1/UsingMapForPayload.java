package MyPractice1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;

public class UsingMapForPayload {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		Map<String, Object> mp = new LinkedHashMap<String, Object>();
		mp.put("name", "jack");
		mp.put("job", "QA lead");
		mp.put("salary", 90000f);
		mp.put("isMarried", true);

		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1").body(mp).when().post("api/users").then().log().all()
				.assertThat().statusCode(201).extract().response().asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String createdDate = js.getString("createdAt");
		String[] s1 = createdDate.split(" ");
		System.out.println(s1[0]);
		Assert.assertEquals(s1[0], java.time.LocalDate.now().toString());
		System.out.println("Assertion passed");
	}
}
