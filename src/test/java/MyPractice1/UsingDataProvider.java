package MyPractice1;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Payload.PayloadData;
import io.restassured.RestAssured;

public class UsingDataProvider {
	@DataProvider(name = "booksData")
	public Object[][] getData() {
		return new Object[][] { { "Selenium Java", "uhgy", "8765" }, { "Appium", "jhre", "9122" },
				{ "Robot framework", "gtrf", "6599" } };
	}

	@Test(dataProvider = "booksData")
	public void addBook(String bookName, String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";

		String Response = given().log().all().header("content-type", "application/json")
				.body(PayloadData.getBookDetails1(bookName, isbn, aisle)).when().post("Library/Addbook.php").then()
				.log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Response);
	}
}
