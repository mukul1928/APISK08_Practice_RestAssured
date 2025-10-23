package POJOEx5;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class CreateEmployee5 {
	public static void main(String[] args) throws JsonProcessingException {
		List<String> landmark = new ArrayList<String>();
		landmark.add("ABC sweets");
		landmark.add("Gk hotel");
		landmark.add("JK mall");
		
		HouseDetailsPOJO obj1 = new HouseDetailsPOJO();
		obj1.setFlatNo(0007);
		obj1.setStreet("MG Road");
		obj1.setLandmark(landmark);
		
		EmpAddress5POJO empAddress = new EmpAddress5POJO();
		empAddress.setHdpojo(obj1);
		empAddress.setCity("Pune");
		empAddress.setState("Maharastra");
		empAddress.setZip(700055);
		
		List<String> banks = new ArrayList<String>();
		banks.add("SBI");
		banks.add("HDFC");
		banks.add("ICICI");
		
		Employee5Pojo emp = new Employee5Pojo();
		emp.setName("Harry");
		emp.setAge(35);
		emp.setSalary(1000000f);
		emp.setEmpAddress(empAddress);
		emp.setBank(banks);
		
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
