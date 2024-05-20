package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import base.TestBase;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

public class TC001_LoginValidation extends TestBase {
	TestBase tb;

	@BeforeClass
	public void loginAPI() {
		tb = new TC001_LoginValidation();
		tb.loginHubWalletTerminal();
	}

	@Test		//Validate Response Body
	public void loginAPI_ResponseBody() {
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody != null);
		
		JsonPath js = resources.ReusableMethod.rawToJson(responseBody);
		String BusinessName = js.getString("business_info.business_name");
		System.out.println("Business Name :- "+BusinessName);
		Assert.assertEquals(BusinessName, "Look's Salon");
	}

	@Test		//Validate Status Code
	public void loginAPI_StatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test		// Validate Status Line
	public void loginAPI_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test		// Validate Response Line	
	public void loginAPI_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < 5000);
	}

	@Test		// Validate Content Type
	public void loginAPI_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content Type :- "+contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test	// Validate Server Type
	public void loginAPI_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server Type :- "+serverType);
		Assert.assertEquals(serverType, "nginx/1.18.0 (Ubuntu)");
	}
	
	@Test // Print all header
	public void loginAPI_printAllHeader() {
		Headers allheaders = response.headers();	//capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for(Header header:allheaders) 
		{
			System.out.println(header.getName()+"  :-  "+header.getValue());			
		}
		System.out.println("<------------------------------------------------------------>");
	}
}
