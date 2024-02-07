package testCase;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import pojo.GetCheckoutData;
import pojo.GetCheckoutDataServices;
import resources.ReusableMethod;

public class TC004_Get_Checkout_Data extends TestBase{
	
	TestBase tb;
	GetCheckoutData getCheckoutData;
	
	@BeforeClass
	public void getCheckOutData() throws IOException {
		tb = new TC004_Get_Checkout_Data();
		
		String customer_id = "2167";
		String token_no = "37471";
		String vendor_id = "71";
		String deposit_id = "";
		String checkout_type = "Multiple";
		String search = "";

		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				queryParam("customer_id",customer_id).
				queryParam("token_no",token_no).
				queryParam("vendor_id",vendor_id).
				queryParam("deposit_id",deposit_id).
				queryParam("checkout_type",checkout_type).
				queryParam("search",search).
				header("Content-Type", "application/json").
				header("Authorization", "Bearer "+tb.loginHubWalletTerminal());

		response = httpRequest.request(Method.GET, "/checkout/getCheckoutData");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		String body = response.getBody().asString();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		getCheckoutData = objectMapper.readValue(body, GetCheckoutData.class);
	}

	@Test // validate Response Body
	public void getCheckoutData_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		AssertJUnit.assertTrue(responseBody != null);
		
		List<GetCheckoutDataServices> result = getCheckoutData.getServices();
		
		for(int i=0; i<result.size(); i++) {
			
			System.out.println("Service Name : "+result.get(i).getService_name()+" | "+"Stylist Name : "+result.get(i).getStylist_name());
			
		}
	}

	@Test // Validate Status Code
	public void getCheckoutData_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		AssertJUnit.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void getCheckoutData_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void getCheckoutData_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		AssertJUnit.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void getCheckoutData_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void getCheckoutData_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void getCheckoutData_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());
		}
		System.out.println("<------------------------------------------------------------>");
	}

}
