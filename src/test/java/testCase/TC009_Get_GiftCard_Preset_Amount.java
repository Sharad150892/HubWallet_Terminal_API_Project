package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.io.IOException;
import org.testng.Assert;
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
import pojo.GetGiftCardPresetAmount;
import pojo.GetGiftCardPresetAmountResult;
import resources.ReusableMethod;

public class TC009_Get_GiftCard_Preset_Amount extends TestBase {
	
	TestBase tb;
	GetGiftCardPresetAmount getGiftCardPresetAmount;

	@BeforeClass
	public void getGiftCardPresetAmount() throws IOException {
		tb = new TC009_Get_GiftCard_Preset_Amount();
		
		String vendor_id = "71";

		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				queryParam("vendor_id",vendor_id).
				header("Content-Type", "application/json").
				header("Authorization", "Bearer "+tb.loginHubWalletTerminal());

		response = httpRequest.request(Method.GET, "/checkout/getGiftCardPresetAmount");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		String body = response.getBody().asString();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		getGiftCardPresetAmount = objectMapper.readValue(body, GetGiftCardPresetAmount.class);
	}

	@Test // validate Response Body
	public void getGiftCardPresetAmount_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		Assert.assertTrue(responseBody != null);	
		
		GetGiftCardPresetAmountResult result = getGiftCardPresetAmount.getResult();
		System.out.println("Preset Amount 1:- "+result.getPreset_amount_1());
		System.out.println("Preset Amount 2:- "+result.getPreset_amount_2());
		System.out.println("Preset Amount 3:- "+result.getPreset_amount_3());
		System.out.println("Preset Amount 4:- "+result.getPreset_amount_4());
	}

	@Test // Validate Status Code
	public void getGiftCardPresetAmount_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void getGiftCardPresetAmount_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void getGiftCardPresetAmount_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void getGiftCardPresetAmount_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void getGiftCardPresetAmount_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void getGiftCardPresetAmount_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}


}
