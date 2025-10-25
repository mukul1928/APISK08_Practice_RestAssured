package ExcelIntegration;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateEmployee {
	public static void main(String[] args) throws IOException {
		FetchDataFromExcel obj = new FetchDataFromExcel(ConstantData.ExcelPath,ConstantData.SheetName);
		Map<String,Object> mp = new LinkedHashMap<String,Object>();
		mp.put("empid", FetchDataFromExcel.getData(1, 0));
		mp.put("Firstname", FetchDataFromExcel.getData(1, 1));
		mp.put("GrossSalary", FetchDataFromExcel.getData(1, 2));
		mp.put("married", FetchDataFromExcel.getData(1, 3));
		
		RestAssured.baseURI = "https://reqres.in/";
		String Response = given().log().all().header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1").body(mp)
				.when().post("api/users")
				.then().log().all()
				.assertThat().statusCode(201)
				.extract().response().asString();
		System.out.println(Response);
	}
}
