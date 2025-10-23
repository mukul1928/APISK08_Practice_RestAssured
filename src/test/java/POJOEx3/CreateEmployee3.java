package POJOEx3;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class CreateEmployee3 {
	public static void main(String[] args) throws JsonProcessingException {
		EmployeeAddress3Pojo empaddress = new EmployeeAddress3Pojo();
		empaddress.setCity("Pune");
		empaddress.setState("Maharastra");
		empaddress.setPincode(700044);
		
		List<String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("ICICI");
		banks.add("SBI");
		
		Employee3Pojo emp = new Employee3Pojo();
		emp.setName("Harry");
		emp.setJob("QA Manager");
		emp.setMarried(false);
		emp.setSalary(95000f);
		emp.setEmpAddress(empaddress);
		emp.setBanks(banks);
		
		ObjectMapper obj = new ObjectMapper();
		String empJson = obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1")
				.body(empJson)
				.when().post("api/users")
				.then().log().all()
				.assertThat().statusCode(201).extract().response().asString();
					System.out.println(Response);
	}
}
