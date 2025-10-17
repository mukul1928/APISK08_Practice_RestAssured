package RequestResponseSpecification2;

import static io.restassured.RestAssured.given;

import Payload.PayloadData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReUsableSpec 
{
	
	public static RequestSpecification getRequest()
	{	
		String token = "Bearer 8c6b19bd19640fc01011df0b6371fe5da980740f4f1293951d874fcb718b287d";
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://gorest.co.in")
				.setContentType(ContentType.JSON).setRelaxedHTTPSValidation().setBody(PayloadData.goRestPayload())
				.build();
		
		RequestSpecification respec = given().log().all().header("Authorization",token).spec(req);
		return respec;
	}
	
	public static ResponseSpecification getResponse(int statuscode) 
	{
		ResponseSpecification res = (ResponseSpecification) new ResponseSpecBuilder()
		.expectStatusCode(statuscode).build();
		return res;
	}
}
