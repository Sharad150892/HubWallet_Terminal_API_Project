package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import resources.ReusableMethod;

public class TC017_Check_Number extends TestBase{
	
	TestBase tb;

	@BeforeClass
	public void checkNumber() throws IOException {
		tb = new TC013_Get_Product_Discount();

		String vendor_id = "71";
		String number_check = "5";
		String service_id = "1199";
		String type = "cart";

		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				queryParam("vendor_id", vendor_id).
				queryParam("number_check", number_check).
				queryParam("service_id", service_id).
				queryParam("type", type)
				.header("content-type", "application/json")
				.header("Authorization", "Bearer " + tb.loginHubWalletTerminal());

		response = httpRequest.request(Method.GET, "/checkout/check_number");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
	}

	@Test // validate Response Body
	public void checkNumber_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		Assert.assertTrue(responseBody != null);
		JsonPath js = ReusableMethod.rawToJson(responseBody);
		System.out.println("Message :- "+js.getString("message"));

	}

	@Test // Validate Status Code
	public void checkNumber_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void checkNumber_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void checkNumber_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void checkNumber_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void checkNumber_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void checkNumber_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}

}
