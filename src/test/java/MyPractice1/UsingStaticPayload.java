package MyPractice1;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UsingStaticPayload {
	public static void main(String[] args) throws IOException {
		RestAssured.baseURI = "https://reqres.in";

		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1")
				.body(new String(Files
						.readAllBytes(Paths.get("E:\\API_Automation_08_SK_GrotechMinds\\staticPayloadData7thOct.txt"))))
				.when().post("api/users").then().log().all().assertThat().statusCode(201).extract().response()
				.asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		// ‪E:\API_Automation_08_SK_GrotechMinds\staticPayloadData7thOct.txt
	}
}
