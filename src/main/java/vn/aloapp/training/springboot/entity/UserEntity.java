package vn.aloapp.training.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "gender")
	private boolean gender;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "is_expire")
	private boolean isExpire;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "ward_id")
	private int wardId;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "district_id")
	private int districtId;
	
	@Column(name = "fb_uid")
	private String fbUid;
	
	@Column(name = "gg_uid")
	private String ggUid;
	
	@Column(name = "apple_uid")
	private String appleUid;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "passwords")
	private String password;
	
	@Column(name = "auth_type")
	private int authType;
	
	@Column(name = "verify_code")
	private int verifyCode;
	
	@Column(name = "verify_fail_count")
	private int verifyFailCount;
	
	@Column(name = "is_verified")
	private int isVerified;
	
	@Column(name = "last_activity_at")
	private Date lastActivityAt;
	
	@Column(name = "last_login_at")
	private	Date lastLoginAt;
	 
	@Column(name = "access_token")
	private String accessToken;
	
	@Column(name = "refesh_token")
	private String refeshToken;
	
	@Column(name = "is_verify_code_at")
	private Date isVerifyCodeAt;

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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
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
	
	public String getAvatar() {
		return avatar;
	}

	public boolean isExpire() {
		return isExpire;
	}

	public void setExpire(boolean isExpire) {
		this.isExpire = isExpire;
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

	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
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

	public Date getLastActivityAt() {
		return lastActivityAt;
	}

	public void setLastActivityAt(Date lastActivityAt) {
		this.lastActivityAt = lastActivityAt;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefeshToken() {
		return refeshToken;
	}

	public void setRefeshToken(String refeshToken) {
		this.refeshToken = refeshToken;
	}

	public Date getIsVerifyCodeAt() {
		return isVerifyCodeAt;
	}

	public void setIsVerifyCodeAt(Date isVerifyCodeAt) {
		this.isVerifyCodeAt = isVerifyCodeAt;
	}
	
	
}
