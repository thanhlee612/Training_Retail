package vn.aloapp.training.springboot.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDataModel {
@JsonProperty("id")
private int id;

@JsonProperty("phone")
private String phone;

@JsonProperty("passwords")
private String password;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
