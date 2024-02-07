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
import pojo.AddCustomer;
import resources.ReusableMethod;

public class TC012_Add_Customer extends TestBase{
	
	TestBase tb;
	AddCustomer addCustomer;
	
	@BeforeClass
	public void addCustomer() throws IOException {
		tb = new TC012_Add_Customer();
		addCustomer = new AddCustomer();
		
		addCustomer.setVendor_id("71");
		addCustomer.setFirstname("Sam");
		addCustomer.setLastname("Simon");
		addCustomer.setMobile("(458) 778-8675");
		addCustomer.setEmail("simon@mailinator.com");
		
		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				header("content-type","application/json").
				header("Authorization","Bearer "+tb.loginHubWalletTerminal()).body(addCustomer);
		
		response = httpRequest.request(Method.POST,"/checkout/add");
		
		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
	}
	
	@Test // validate Response Body
	public void addCustomer_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		Assert.assertTrue(responseBody != null);
		
		JsonPath js = ReusableMethod.rawToJson(responseBody);
		System.out.println("Message :- "+js.getString("message"));
		
	}

	@Test // Validate Status Code
	public void addCustomer_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void addCustomer_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void addCustomer_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void addCustomer_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void addCustomer_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void addCustomer_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}

}
