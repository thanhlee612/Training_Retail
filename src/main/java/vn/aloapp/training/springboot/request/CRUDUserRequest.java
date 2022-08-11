package vn.aloapp.training.springboot.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDUserRequest {

	@NotNull(message = "không được để trống")
	@JsonProperty("first_name")
	private String firstName;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("last_name")
	private String lastName;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("gender")
	private int gender;
	
	@JsonProperty("birthday")
	private Date birthday;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("is_expire")
	private int isExpire;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("avatar")
	private String avatar;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("ward_id")
	private int wardId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("city_id")
	private int cityId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("district_id")
	private int districtId;
	
	
	@JsonProperty("fb_uid")
	private String fbUid;
	
	
	@JsonProperty("gg_uid")
	private String ggUid;
	
	
	@JsonProperty("apple_uid")
	private String appleUid;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("passwords")
	private String password;
	
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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

	public String getFbUid() {
		return fbUid;
	}

	public void setFbUid(String fbUid) {
		this.fbUid = fbUid;
	}

	public String getGgUid() {
		return ggUid;
	}

	public void setGgUid(String ggUid) {
		this.ggUid = ggUid;
	}

	public String getAppleUid() {
		return appleUid;
	}

	public void setAppleUid(String appleUid) {
		this.appleUid = appleUid;
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
