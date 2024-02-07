package base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public static String token;
	
	
	public String loginHubWalletTerminal() {

		RestAssured.baseURI = "https://hubwallet.com/api_terminal";

		httpRequest = RestAssured.given().log().all().
				queryParam("pin", "61548237").queryParam("device_id", "ae80645149157722").
				header("Content-Type", "application/json");

		response = httpRequest.request(Method.GET, "/login/login");

		String responseBody = response.getBody().asString();

		JsonPath js = new JsonPath(responseBody);
		token = js.getString("token");
		System.out.println("Token after Login :- " + token);
		
		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		
		return token;
	}
}
