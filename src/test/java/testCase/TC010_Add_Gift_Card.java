package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.io.IOException;

import org.testng.Assert;
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
import pojo.AddGiftCard;
import resources.ReusableMethod;

public class TC010_Add_Gift_Card extends TestBase{
	
	TestBase tb;
	AddGiftCard addGiftCard;
	
	@BeforeClass
	public void addGiftCard() throws IOException {
		tb = new TC010_Add_Gift_Card();
		addGiftCard = new AddGiftCard();
		addGiftCard.setGift_card_number("12345678");
		addGiftCard.setCard_buyer_name("Aron");
		addGiftCard.setCard_buyer_email("aron@mailinator.com");
		addGiftCard.setCard_message("Hello");
		addGiftCard.setCard_customer_id("1235466");
		addGiftCard.setCard_amount("20");
		addGiftCard.setNotifyBy_card("1");
		addGiftCard.setMyself("1");
		addGiftCard.setRecipient_name("Baron");
		addGiftCard.setRecipient_email("baron@mailinator.com");
		addGiftCard.setTemplate_image_id("234");
		addGiftCard.setVendor_id("71");
		
		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				header("content-type","application/json").
				header("Authorization","Bearer "+tb.loginHubWalletTerminal()).body(addGiftCard);
		
		response = httpRequest.request(Method.POST,"/checkout/add_gift_card");
		
		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
	}
	
	@Test // validate Response Body
	public void addGiftCard_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		Assert.assertTrue(responseBody != null);
		
		JsonPath js = ReusableMethod.rawToJson(responseBody);
		System.out.println("Message :- "+js.getString("message"));
		
	}

	@Test // Validate Status Code
	public void addGiftCard_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void addGiftCard_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void addGiftCard_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void addGiftCard_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void addGiftCard_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void addGiftCard_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}
}
