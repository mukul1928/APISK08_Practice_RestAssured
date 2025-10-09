package MyPractice1;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import Payload.PayloadData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LiberaryAPIEx {
	public static void main(String[] args) {

		String ExpectedMessage = "successfully added";

		RestAssured.baseURI = "http://216.10.245.166";
		String isbn = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(0, 4);
		Integer aisle = 1000 + new java.util.Random().nextInt(9000);

		String ExpectedId = isbn + aisle.toString();

		String Response = given().log().all().header("content-type", "application/json")
				.body(PayloadData.getBookDetails(isbn, aisle)).when().post("Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(Response);// JsonPath is one of a class which helps you to traverse through this
												// response and fetch you the value from that response body
		String Actualmessage = js.getString("Msg");
		Assert.assertEquals(Actualmessage, ExpectedMessage);
		String ActualID = js.getString("ID");
		Assert.assertEquals(ActualID, ExpectedId);
		System.out.println("Test Case Pass");
	}
}
