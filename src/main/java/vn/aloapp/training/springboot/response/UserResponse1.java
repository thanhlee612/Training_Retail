package vn.aloapp.training.springboot.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.UserEntity;

public class UserResponse1 {
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("birthday")
	private Date birthday;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("is_expire")
	private int isExpire;
	
	@JsonProperty("avatar")
	private String avatar;
	
	@JsonProperty("ward_id")
	private int wardId;
	
	@JsonProperty("city_id")
	private int cityId;
	
	@JsonProperty("district_id")
	private int districtId;
	
	@JsonProperty("access_token")
	private String accessToken;
	
	
	public UserResponse1(UserEntity e) {
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.fullName = e.getFullName();
		this.avatar = e.getAvatar();
		this.phone = e.getPhone();
		this.gender = e.isGender() ? "Nam" : "Nữ";
		this.birthday = e.getBirthday();
		this.email = e.getEmail();
		this.isExpire = e.isExpire() ? 1 : 0;
		this.avatar = e.getAvatar();
		this.wardId = e.getWardId();
		this.cityId = e.getCityId();
		this.districtId = e.getDistrictId();
		this.accessToken = e.getAccessToken();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsExpire() {
		return isExpire;
	}

	public void setIsExpire(int isExpire) {
		this.isExpire = isExpire;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
