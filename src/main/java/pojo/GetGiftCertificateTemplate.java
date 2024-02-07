package pojo;

import java.util.List;

public class GetGiftCertificateTemplate {
	
	private String status;
	private String message;
	private List<GetGiftCertificateTemplateResult> result;
	
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
	public List<GetGiftCertificateTemplateResult> getResult() {
		return result;
	}
	public void setResult(List<GetGiftCertificateTemplateResult> result) {
		this.result = result;
	}
	
}
