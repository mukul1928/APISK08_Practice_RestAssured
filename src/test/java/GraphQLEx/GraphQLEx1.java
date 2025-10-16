package GraphQLEx;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class GraphQLEx1 {
	public static void main(String[] args) {
		String query = "query  {\r\n"
				+ "   country (code: \"IN\") {\r\n"
				+ "     name\r\n"
				+ "     capital\r\n"
				+ "      }\r\n"
				+ "}";
		
		
		JSONObject payload = new JSONObject();
				payload.put("query", query);
				String reqBody = payload.toString();
				
				Response response = RestAssured.given().baseUri("https://countries.trevorblades.com/")
				.header("content-type","application/json")
				.body(reqBody)
				.when().post();
				
				System.out.println("Status code is "+ response.statusCode());
				System.out.println("The entire response is "+ response.prettyPrint());
				
				String countryName = response.jsonPath().getString("data.country.name");
				System.out.println(countryName);
				String countryCapital = response.jsonPath().getString("data.country.capital");
				System.out.println(countryCapital);
	}
}
