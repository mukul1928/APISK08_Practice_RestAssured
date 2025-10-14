package AuthenticationEx;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

// if you are sending the body in x-www-from-urlencoded 
// so in place of .body we pass .param and the values of x-www-from-urlencoded what we used in postman

public class OAuth2Ex {
	String access_token;

	@Test(priority = 1)

	public void getAccessToken() {
		RestAssured.baseURI = "https://api-m.sandbox.paypal.com";
		String client_id = "AX1JimYNtpUrYvFVtJOG_L-NS4Lfn5MbFmH2uBfhPJtxndz0o9eRCOuVDPU3IZxIfEx1L0_i7HgvWTpt";
		String client_secret_id = "EBdzETNCGESs2lDeGJc6b7_-7p2C0L4rsrFXpRbizYDsd5H9a8PIiufjIprpOcx0JjvbPO0fnjDqmZfy";

		String Response = given().log().all()
				.header("content-type", "application/x-www-form-urlencoded")
				.param("grant_type", "client_credentials")
				.auth().preemptive().basic(client_id, client_secret_id)
				.when().post("v1/oauth2/token")
				.then().log().all().extract().response().asString();
		
		
		JsonPath js = new JsonPath(Response);
		access_token = js.getString(access_token);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	
	@Test(priority=2)
	public void getInvoiceDetails() {
		RestAssured.baseURI = "https://api-m.sandbox.paypal.com";
		String Res = given().log().all().queryParam("page",3)
		.queryParam("page_size",4).queryParam("total_count_required",true)
		.auth().oauth2(access_token)
		.when().get("v1/invoicing/invoices")
		.then().log().all().extract().response().asString();
		System.out.println(Res);
	}
}
