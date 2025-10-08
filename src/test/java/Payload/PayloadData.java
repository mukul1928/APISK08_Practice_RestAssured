package Payload;

public class PayloadData {
	public static String addEmp(String name,String job) {
		String empBody = "{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return empBody;
	}
}
