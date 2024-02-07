package pojo;

import java.util.List;

public class GetServiceList {
	
	private String status;
	private String message;
	private List<GetServiceListResult> result;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<GetServiceListResult> getResult() {
		return result;
	}
	public void setResult(List<GetServiceListResult> result) {
		this.result = result;
	}
}
