package HandlingDBConnection;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class GetDBDetails {
	public static void main(String[] args) throws SQLException {
		
		Map<String,Object> mp = new LinkedHashMap<String,Object>();
		mp.put("id", CreateConnection.getDetailsDB(1));
		mp.put("name", CreateConnection.getDetailsDB(2));
		mp.put("address", CreateConnection.getDetailsDB(3));
		mp.put("salary", CreateConnection.getDetailsDB(4));
		
		RestAssured.baseURI = "https://reqres.in/";
		
		
		String Response = given().log().all()
				
				.header("content-type", "application/json")
				.header("x-api-key", "reqres-free-v1")
				.body(mp)
				.when().post("api/users")
				.then().log().all().assertThat().statusCode(201)
				.header("content-type", "application/json").extract().response().asString();
		System.out.println(Response);
	}
}
