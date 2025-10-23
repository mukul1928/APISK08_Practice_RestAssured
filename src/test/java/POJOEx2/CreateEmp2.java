package POJOEx2;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class CreateEmp2 {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		EmployeeAddressPojo x = new EmployeeAddressPojo();
		x.setCity("Pune");
		x.setState("Maharastra");
		x.setPincode(273001);
		
		Employee2pojo emp = new Employee2pojo();
		emp.setName("Harry");
		emp.setJob("QA Lead");
		emp.setMarried(false);
		emp.setEmpAddress(x);
		emp.setSalary(250000f);
		
		ObjectMapper obj = new ObjectMapper();
		String empJSON = obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);// We are doing Serialization here
		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1")
				.body(empJSON)
				.when().post("api/users")
				.then().log().all()
				.assertThat().statusCode(201).extract().response().asString();
					System.out.println(Response);

					Employee2pojo empObj = obj.readValue(Response, Employee2pojo.class);// DeSerialization
		String name1 = empObj.getName();
		String job1 = empObj.getJob();
		float salary1 = empObj.getSalary();
		boolean isMarried1 = empObj.isMarried();
		EmployeeAddressPojo address1 = empObj.getEmpAddress();
		System.out.println(name1 + " " + job1 + " " + salary1 + " " + isMarried1 + " " + address1);
	}
}
