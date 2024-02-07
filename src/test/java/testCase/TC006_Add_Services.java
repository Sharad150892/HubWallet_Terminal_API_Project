package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import pojo.AddService;
import resources.ReusableMethod;

public class TC006_Add_Services extends TestBase{
	
	TestBase tb;
	AddService addService;

	@BeforeClass
	public void addServicesInCheckout() throws IOException {
		tb = new TC006_Add_Services();
		addService = new AddService();
		addService.setCustomer_id("2144");
		addService.setToken_no("0");
		addService.setVendor_id("71");
		addService.setAppointment_type("single");
		addService.setDuration("45");
		addService.setService("312");
		addService.setAmount_service("2999");

		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				header("Content-Type", "application/json").
				header("Authorization", "Bearer "+tb.loginHubWalletTerminal()).body(addService);

		response = httpRequest.request(Method.POST, "/checkout/add_service");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
	}

	@Test // validate Response Body
	public void addService_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		Assert.assertTrue(responseBody != null);		
	}

	@Test // Validate Status Code
	void addService_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	void addService_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	void addService_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	void addService_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	void addService_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	void addService_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<---------------------Request Header------------------------------------->");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}


}
