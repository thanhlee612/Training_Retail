package vn.aloapp.training.springboot.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.UserEntity;

public class UserResponseVerifyCode {
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("verify_code")
	private int verifyCode;

	public UserResponseVerifyCode(UserEntity u) {
		this.phone = u.getPhone();
		this.verifyCode = u.getVerifyCode();
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
