package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCustomerList {
	
	private int status;
	private String message;
	private List<GetCustomerListResult> result;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<GetCustomerListResult> getResult() {
		return result;
	}
	public void setResult(List<GetCustomerListResult> result) {
		this.result = result;
	}
	
	

}
