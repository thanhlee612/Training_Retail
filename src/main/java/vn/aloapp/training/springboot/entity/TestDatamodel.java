package vn.aloapp.training.springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestDatamodel {
	
	
@JsonProperty("phone")
private String phone;

@JsonProperty("passwords")
private String passwords;

@JsonProperty("access_token")
private String acesstoken;

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPasswords() {
	return passwords;
}

public void setPasswords(String passwords) {
	this.passwords = passwords;
}

public String getAcesstoken() {
	return acesstoken;
}

public void setAcesstoken(String acesstoken) {
	this.acesstoken = acesstoken;
}

}
