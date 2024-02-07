package pojo;

public class AddService {
	
	private String customer_id;
	private String token_no;
	private String vendor_id;
	private String appointment_type;
	private String duration;
	private String service;
	private String amount_service;
	
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	public String getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getAppointment_type() {
		return appointment_type;
	}
	public void setAppointment_type(String appointment_type) {
		this.appointment_type = appointment_type;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getAmount_service() {
		return amount_service;
	}
	public void setAmount_service(String amount_service) {
		this.amount_service = amount_service;
	}
}
