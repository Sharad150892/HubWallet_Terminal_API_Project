package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

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
import pojo.GetGiftCertificateTemplate;
import pojo.GetGiftCertificateTemplateResult;
import resources.ReusableMethod;

public class TC007_Get_Gift_CertificateTemplate extends TestBase{
	
	TestBase tb;
	GetGiftCertificateTemplate getGiftCertificateTemplate;

	@BeforeClass                 
	public void getGiftCertificateTemplate() throws IOException {
		tb = new TC007_Get_Gift_CertificateTemplate();
		
		String vendor_id = "71";
		String type = "checkout";

		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				queryParam("vendor_id",vendor_id).queryParam("type",type).
				header("Content-Type", "application/json").
				header("Authorization", "Bearer "+tb.loginHubWalletTerminal());

		response = httpRequest.request(Method.GET, "/checkout/getGiftCertificateTemplate");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		String body = response.getBody().asString();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		getGiftCertificateTemplate = objectMapper.readValue(body, GetGiftCertificateTemplate.class);
	}

	@Test // validate Response Body
	public void getGiftCertificateTemplate_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		AssertJUnit.assertTrue(responseBody != null);	
		
		List<GetGiftCertificateTemplateResult> result = getGiftCertificateTemplate.getResult();
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println("Image ID:-"+result.get(i).getImage_id());
		}
		
	}

	@Test // Validate Status Code
	public void getGiftCertificateTemplate_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		AssertJUnit.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void getGiftCertificateTemplate_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void getGiftCertificateTemplate_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		AssertJUnit.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void getGiftCertificateTemplate_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		AssertJUnit.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void getGiftCertificateTemplate_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		AssertJUnit.assertEquals(serverType,"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void getGiftCertificateTemplate_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}


}
