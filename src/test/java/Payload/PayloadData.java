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
	
	public static String getPayloadData(int id) {
		String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>"+id+"</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		return payload;
	}
}
