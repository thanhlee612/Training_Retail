package vn.aloapp.training.springboot.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.UserEntity;

public class UserResponseUpdatePassword {
	@JsonProperty("phone")
	private String phone;

	@JsonProperty("access_token")
	private String accessToken;
	
	public UserResponseUpdatePassword(UserEntity u) {
		this.phone = u.getPhone();
		this.accessToken = u.getAccessToken();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
