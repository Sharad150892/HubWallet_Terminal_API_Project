package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import base.TestBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ReusableMethod extends TestBase{
	
	public static RequestSpecification req;

	public static JsonPath rawToJson(String response) {

		JsonPath js1 = new JsonPath(response);

		return js1;
	}
	
//	public static RequestSpecification baseURI() {
//		RequestSpecification req =   new RequestSpecBuilder().setBaseUri("http://162.243.160.161/salon/terminal_app").build();
//		
//		return req;
//	}
	
	
	public static RequestSpecification baseURI() throws IOException
	{
		
		if(req==null) {
			PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
			req =new RequestSpecBuilder().setBaseUri(("https://hubwallet.com/api_terminal/")).
					addFilter(RequestLoggingFilter.logRequestTo(log))
					 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON).build();
			 return req;
		}
		return req;
	}
	

}
