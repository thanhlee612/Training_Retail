package vn.aloapp.training.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.UserEntity;

public class UserResponse {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("gender")
	private int gender;
	
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
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("passwords")
	private String password;
	
	@JsonProperty("auth_type")
	private int authType;
	
	@JsonProperty("verify_fail_count")
	private int verifyFailCount;
	
	@JsonProperty("is_verified")
	private int isVerified;
	 
	@JsonProperty("access_token")
	private String accessToken;
	

	public UserResponse(UserEntity u) {
		this.id = u.getId();
		this.firstName = u.getFirstName();
		this.lastName = u.getLastName();
		this.fullName = u.getFullName();
		this.gender = u.isGender() ? 1 : 0;
		this.email = u.getEmail();
		this.isExpire = u.isExpire() ? 1 : 0;
		this.avatar = u.getAvatar();
		this.wardId = u.getWardId();
		this.cityId = u.getCityId();
		this.districtId = u.getDistrictId();
		this.phone = u.getPhone();
		this.password = u.getPassword();
		this.accessToken = u.getAccessToken();

	}

	public List<UserResponse> mapToList(List<UserEntity> user){
		return user.stream().map(x -> new UserResponse(x)).collect(Collectors.toList());
	}
	
	
	public UserResponse() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}


	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getVerifyFailCount() {
		return verifyFailCount;
	}

	public void setVerifyFailCount(int verifyFailCount) {
		this.verifyFailCount = verifyFailCount;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}


	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
