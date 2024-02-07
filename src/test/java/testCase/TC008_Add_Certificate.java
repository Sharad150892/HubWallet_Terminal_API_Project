package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import pojo.AddCertificate;
import resources.ReusableMethod;

public class TC008_Add_Certificate extends TestBase{
	
	TestBase tb;
	AddCertificate addCertificate;

	@BeforeClass
	public void addCertificate() throws IOException {
		tb = new TC008_Add_Certificate();
		addCertificate = new AddCertificate();
		addCertificate.setGift_certificate_no("500");
		addCertificate.setService_id("123");
		addCertificate.setGift_type("Thanks Giving");
		addCertificate.setCustomer_id("2144");
		addCertificate.setAmount_type("1");
		addCertificate.setAmount("50");
		addCertificate.setExpire_on("08-31-2023");
		addCertificate.setNotifyBy("123");
		addCertificate.setTemplate_image_id("222");
		addCertificate.setMessage("Added");
		addCertificate.setMessage_custom("123");
		addCertificate.setLogin_id("242");
		addCertificate.setVendor_id("71");
	
		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				header("Content-Type", "application/json").
				header("Authorization", "Bearer "+tb.loginHubWalletTerminal()).body(addCertificate);

		response = httpRequest.request(Method.POST, "/checkout/add_certificate");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		String body = response.getBody().asString();
	}

	@Test // validate Response Body
	public void addCertificate_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		AssertJUnit.assertTrue(responseBody != null);
		
		JsonPath js = ReusableMethod.rawToJson(responseBody);
		System.out.println("Message :- "+js.getString("message"));
		
	}

	@Test // Validate Status Code
	public void addCertificate_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		AssertJUnit.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void addCertificate_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void addCertificate_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		AssertJUnit.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void addCertificate_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		AssertJUnit.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void addCertificate_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		AssertJUnit.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void addCertificate_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}


}
