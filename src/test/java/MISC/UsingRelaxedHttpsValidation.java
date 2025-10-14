package MISC;
import static io.restassured.RestAssured.*;

public class UsingRelaxedHttpsValidation {
	public static void main(String[] args) {

		String Response = 
				given()
					.log().all()
					.relaxedHTTPSValidation()
					.when()
					.get("https://self-signed.badss1.com/")
					.then()
					.extract()
					.response()
					.asString();
					System.out.println(Response);
	}
}
