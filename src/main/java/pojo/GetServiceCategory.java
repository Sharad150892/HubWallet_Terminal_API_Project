package pojo;

import java.util.List;

public class GetServiceCategory {
	
	private String status;
	private String message;
	private List<GetServiceCategoryResult> result;
	
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
	public List<GetServiceCategoryResult> getResult() {
		return result;
	}
	public void setResult(List<GetServiceCategoryResult> result) {
		this.result = result;
	}
}
