package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCheckoutDataServices {
	
	private String	appointment_type;
	private String	as_id;
	private String	appointment_id;
	private String	appointment_time;
	private String	price;
	private String	duration;
	private String	points;
	private String	service_id;
	private String	stylist_id;
	private String	parent_id;
	private String	appointment_date;
	private String	customer_id;
	private String	service_name;
	private String	is_tax;
	private String	tax_type;
	private String	tax_rate;
	private String	service_point;
	private String	tip;
	private String	stylist_name;
	
	public String getAppointment_type() {
		return appointment_type;
	}
	public void setAppointment_type(String appointment_type) {
		this.appointment_type = appointment_type;
	}
	public String getAs_id() {
		return as_id;
	}
	public void setAs_id(String as_id) {
		this.as_id = as_id;
	}
	public String getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getService_id() {
		return service_id;
	}
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	public String getStylist_id() {
		return stylist_id;
	}
	public void setStylist_id(String stylist_id) {
		this.stylist_id = stylist_id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getIs_tax() {
		return is_tax;
	}
	public void setIs_tax(String is_tax) {
		this.is_tax = is_tax;
	}
	public String getTax_type() {
		return tax_type;
	}
	public void setTax_type(String tax_type) {
		this.tax_type = tax_type;
	}
	public String getTax_rate() {
		return tax_rate;
	}
	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}
	public String getService_point() {
		return service_point;
	}
	public void setService_point(String service_point) {
		this.service_point = service_point;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getStylist_name() {
		return stylist_name;
	}
	public void setStylist_name(String stylist_name) {
		this.stylist_name = stylist_name;
	}
	
}
