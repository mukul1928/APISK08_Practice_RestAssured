package MyPractice1;

import org.testng.Assert;

import MockResponse.CourseDetails;
import io.restassured.path.json.JsonPath;

public class HandlingMockJson {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(CourseDetails.getCourseDetails());
		// 1 Print No of courses returned by API
		int coursesize = js.getInt("courses.size()");
		System.out.println("Total number of courses is " + coursesize);
		// 2 Print purchase amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("The total purchase amount is " + purchaseAmount);
		// 3 Print title of the first course
		String titleFirstCourse = js.getString("courses[0].title");
		System.out.println("Title of first course is " + titleFirstCourse);
		// 4 Print all the courses title and their respective Prices
		System.out.println("courses title and their respective Prices are as below ");
		for (int i = 0; i < coursesize; i++) {
			String courseTitle = js.getString("courses[" + i + "].title");
			int coursePrice = js.getInt("courses[" + i + "].price");
			System.out.println(courseTitle + " " + coursePrice);
			// 5 Print no of copies sold by RPA course
			String courseRPA = js.getString("courses[2].copies");
			System.out.println("The total number of courses sold by RPA is " + courseRPA);

		}
		// 6 Verify if sum of all Courses price matches with Purchase Amount
		int sum = 0;
		for (int i = 0; i < coursesize; i++) {
			int price = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");
			int amount = price * copies;
			sum = sum + amount;
		}
		System.out.println("The total sum is " + sum);
		Assert.assertEquals(sum, purchaseAmount);
		System.out.println("My test case passed");
	}
}
