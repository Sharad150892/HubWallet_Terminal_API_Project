package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAppointmentList {
	
	private String status;
	private String message;
	private List<GetAppointmentListResult> result;
	private GetAppointmentListBusiness business_info;
	private List<GetAppointmentListCertificateReason> gift_certificate_reson;
	private String certificate_last_id;
	private String giftcard_last_id;
	
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
	public List<GetAppointmentListResult> getResult() {
		return result;
	}
	public void setResult(List<GetAppointmentListResult> result) {
		this.result = result;
	}
	public GetAppointmentListBusiness getBusiness_info() {
		return business_info;
	}
	public void setBusiness_info(GetAppointmentListBusiness business_info) {
		this.business_info = business_info;
	}
	public List<GetAppointmentListCertificateReason> getGift_certificate_reson() {
		return gift_certificate_reson;
	}
	public void setGift_certificate_reson(List<GetAppointmentListCertificateReason> gift_certificate_reson) {
		this.gift_certificate_reson = gift_certificate_reson;
	}
	public String getCertificate_last_id() {
		return certificate_last_id;
	}
	public void setCertificate_last_id(String certificate_last_id) {
		this.certificate_last_id = certificate_last_id;
	}
	public String getGiftcard_last_id() {
		return giftcard_last_id;
	}
	public void setGiftcard_last_id(String giftcard_last_id) {
		this.giftcard_last_id = giftcard_last_id;
	}

}
