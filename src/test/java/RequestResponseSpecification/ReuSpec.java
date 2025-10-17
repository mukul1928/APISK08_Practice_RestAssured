package RequestResponseSpecification;

import static io.restassured.RestAssured.given;

import Payload.PayloadData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReuSpec {
	public static RequestSpecification getRequest() {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.setContentType(ContentType.JSON).setRelaxedHTTPSValidation().setBody(PayloadData.addEmp("Harry", "Manager"))
				.build();
		
		RequestSpecification respec = given().log().all().spec(req);
		return respec;
	}
	public static ResponseSpecification getResponse(int statuscode) {
		ResponseSpecification res = (ResponseSpecification) new ResponseSpecBuilder()
		.expectStatusCode(statuscode).build();
		return res;
	}
}
