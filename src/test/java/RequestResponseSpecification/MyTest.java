package RequestResponseSpecification;

import static io.restassured.RestAssured.*;

public class MyTest {
	public static void main(String[] args) {
		String Response = given().log().all().spec(ReuSpec.getRequest()).when().get("api/users/2").then()
				.spec(ReuSpec.getResponse(200)).extract().response().asString();

		System.out.println(Response);
	}
}
