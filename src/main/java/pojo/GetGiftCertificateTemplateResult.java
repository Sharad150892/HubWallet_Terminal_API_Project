package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGiftCertificateTemplateResult {
	
	private String image_id;
	private String certificate_image;
	private String type;
	private String is_active;
	
	public String getImage_id() {
		return image_id;
	}
	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}
	public String getCertificate_image() {
		return certificate_image;
	}
	public void setCertificate_image(String certificate_image) {
		this.certificate_image = certificate_image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
	
	

}
