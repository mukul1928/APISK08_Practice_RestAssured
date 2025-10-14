package MISC;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
//If you write the .body after given section then it will became the part of your request payload but the same .body 
//if you are writing after .then , it becomes the part of your validation.

public class UsingHamcrestMatcher {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		String Response = given().log().all().when().get("posts/1")
		.then().log().all()
		.body("userId", equalTo(1))
		.body("title", notNullValue())
		.body("title", startsWith("sun"))
		.body("body", endsWith("cto"))
		.body("userId", greaterThan(0))
		.body("userId", lessThan(10))
		.body("title", containsString("sunt"))
	//	.body("body", hasItems("consequuntur"))
		.extract().response().asString();
		
		System.out.println(Response);
	}
}
