package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCheckoutData {
	
	private List<GetCheckoutDataServices> services;
	private String message;
	
	public List<GetCheckoutDataServices> getServices() {
		return services;
	}
	public void setServices(List<GetCheckoutDataServices> services) {
		this.services = services;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
