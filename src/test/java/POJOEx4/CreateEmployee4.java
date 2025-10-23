package POJOEx4;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class CreateEmployee4 {
	public static void main(String[] args) throws JsonProcessingException {
		Employee4Pojo emp = new Employee4Pojo();
		emp.setName("Harry");
		emp.setJob("QA Lead");
		emp.setMarried(false);
		emp.setSalary(200000f);
		
		Employee4Pojo emp2 = new Employee4Pojo();
		emp2.setName("Tom");
		emp2.setJob("QA Manager");
		emp2.setMarried(true);
		emp2.setSalary(300000f);
		
		Employee4Pojo emp3 = new Employee4Pojo();
		emp3.setName("Matt");
		emp3.setJob("QA Architect");
		emp3.setMarried(true);
		emp3.setSalary(500000f);
		
		List<Employee4Pojo> li = new ArrayList<Employee4Pojo>();
		li.add(emp);
		li.add(emp2);
		li.add(emp3);
		
		ObjectMapper obj = new ObjectMapper();
		String empJson = obj.writerWithDefaultPrettyPrinter().writeValueAsString(li);
		
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
