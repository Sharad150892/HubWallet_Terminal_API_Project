package testCase;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
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
import pojo.GetAppointmentList;
import pojo.GetAppointmentListResult;
import resources.ReusableMethod;

public class TC003_Get_Appointment_List extends TestBase{
	
	TestBase tb;
	GetAppointmentList getAppointmentList;
	String CustomerName = "Adam";
	
	@BeforeClass
	public void getAppointmentList() throws IOException {
		tb = new TC003_Get_Appointment_List();

		String vendor_id = "71";

		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				queryParam("vendor_id", vendor_id).
				header("Content-Type", "application/json").
				header("Authorization", "Bearer "+tb.loginHubWalletTerminal());

		response = httpRequest.request(Method.GET, "/appointment/getAppointment");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		String body = response.getBody().asString();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		getAppointmentList = objectMapper.readValue(body, GetAppointmentList.class);
	}

	@Test // validate Response Body
	public void getAppointmentList_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		Assert.assertTrue(responseBody != null);
		
		List<GetAppointmentListResult> result = getAppointmentList.getResult();
		
		for(int i=0; i<result.size(); i++) {
			
			if(result.get(i).getCustomer_name().equalsIgnoreCase(CustomerName)) {
				String token_no = result.get(i).getToken_no();
				String customer_id = result.get(i).getToken_no();
				String appointment_type = result.get(i).getToken_no();
				String vendor_id = result.get(i).getToken_no();
				String deposit_id = result.get(i).getToken_no();
				System.out.println("Customer Name :-"+result.get(i).getCustomer_name());
			}
			
			
		}
	}

	@Test // Validate Status Code
	public void getAppointmentList_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test // Validate Status Line
	public void getAppointmentListAPI_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

	@Test // Validate Response Time
	public void getAppointmentList_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < 5000);
	}

	@Test // Validate Content Type
	public void getAppointmentList_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test // Validate Server Type
	public void getAppointmentList_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType,
				"nginx/1.18.0 (Ubuntu)");
	}

	@Test // Print all Header
	public void getAppointmentList_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}


}
