package Payload;

public class PayloadData {
	public static String addEmp(String name, String job) {
		String empBody = "{\r\n" + "    \"name\": \"" + name + "\",\r\n" + "    \"job\": \"" + job + "\"\r\n" + "}";
		return empBody;
	}

	public static String getBookDetails(String isbn, int aisle) {
		String bookdetails = "{\r\n" + "\r\n" + "\"name\":\"Learn Appium Automation with Java\",\r\n" + "\"isbn\":\""
				+ isbn + "\",\r\n" + "\"aisle\":\"" + aisle + "\",\r\n" + "\"author\":\"John foe\"\r\n" + "}";
		return bookdetails;
	}

	public static String getBookDetails1(String name, String isbn, String aisle) {
		String bookdetails = "{\r\n" + "\r\n" + "\"name\":\"" + name + "\",\r\n" + "\"isbn\":\"" + isbn + "\",\r\n"
				+ "\"aisle\":\"" + aisle + "\",\r\n" + "\"author\":\"John foe\"\r\n" + "}";
		return bookdetails;
	}

	public static String goRestPayload() {
		String payload = "{\r\n" + "    \"id\": 8180139,\r\n" + "    \"name\": \"Tenali Ramakrishna\",\r\n"
				+ "    \"email\": \"tenali.tyhrtfffcd@"+Math.random()+"15ce.com\",\r\n" + "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"active\"\r\n" + "}";
		return payload;
	}
}
