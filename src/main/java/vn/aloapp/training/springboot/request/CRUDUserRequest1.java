package vn.aloapp.training.springboot.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDUserRequest1 {

	@JsonProperty("passwords")
	private String password;
	
	@JsonProperty("new_password")
	private String newPassword;
	
	@JsonProperty("confirm")
	private String confirm;
	
	@JsonProperty("phone")
	private String phone;

	@JsonProperty("verify_code")
	private int verifyCode;
	
	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
