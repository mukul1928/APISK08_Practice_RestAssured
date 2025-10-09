package MyPractice1;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetWithQueryParam {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";

		String Response = given().log().all().queryParam("page", 2).when().get("api/users").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		System.out.println(Response);

		String ExpectedSecondFeature = "Data Persistence";
		JsonPath js = new JsonPath(Response);
		String actualSecondFeature = js.getString("_meta.features[2]");
		Assert.assertEquals(actualSecondFeature, ExpectedSecondFeature, "Vaidation Successfull");
		int expectedYear = js.getInt("data[1].year");
		int actualYear = 2007;
		Assert.assertEquals(actualYear, expectedYear);
		System.out.println("All validations passed");
	}
}
