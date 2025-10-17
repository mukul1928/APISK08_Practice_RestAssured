package RequestResponseSpecification2;
public class MyTest1 {
	public static void main(String[] args) {
		String Response = ReUsableSpec.getRequest().when().post("public/v2/users")
				.then().spec(ReUsableSpec.getResponse(201))
				.extract().response().asString();
		System.out.println(Response);
	}
}
