package vn.aloapp.training.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.CRUDUserRequest1;
import vn.aloapp.training.springboot.request.CRUDUserRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.UserResponse;
import vn.aloapp.training.springboot.response.UserResponse1;
import vn.aloapp.training.springboot.response.UserResponseUpdatePassword;
import vn.aloapp.training.springboot.response.UserResponseVerifyCode;
import vn.aloapp.training.springboot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createUser(@Valid @RequestBody CRUDUserRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = userService.spUCreateUser(w);
		response.setData(new UserResponse(user));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateUser(@RequestBody CRUDUserRequest w, @PathVariable("id") int id)
			throws Exception {
		BaseResponse response = new BaseResponse();
		userService.spUpdateUser(id, w);
		UserEntity user = userService.spGetUserById(id);
		response.setData(new UserResponse(user));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getUserById(@PathVariable(name = "id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = userService.spGetUserById(id);
		response.setData(new UserResponse(user));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> findAllUser(@RequestParam(name = "expire") int expire) throws Exception {
		BaseResponse response = new BaseResponse();
		StoreProcedureListResult<UserEntity> user = userService.spGetAllUser(expire);
		response.setData(new UserResponse().mapToList(user.getResult()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> delete(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		userService.spDedeteUser(id);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> findById(@RequestParam(name = "keyword") String keyword) throws Exception {
		BaseResponse response = new BaseResponse();
		StoreProcedureListResult<UserEntity> user = userService.search(keyword);
		response.setData(new UserResponse().mapToList(user.getResult()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/login", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> login(@PathVariable(name = "id") int id, @RequestBody CRUDUserRequest1 w)
			throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = userService.spLoginUser(id, w);
		response.setData(new UserResponse1(user));
		response.setMessageError("Đăng nhập thành công!");
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/change-password", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spchangePassword(@RequestBody CRUDUserRequest1 w, @PathVariable("id") int id)
			throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity userEntity = userService.spChangePassword(id, w);
		response.setData(new UserResponse(userEntity));
		response.setMessageError("Thay đổi mật khẩu thành công!");
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spForgotPassword(@RequestBody CRUDUserRequest1 w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity userEntity = userService.spForgotPassword(w);
		response.setData(new UserResponseVerifyCode(userEntity));
		response.setMessageError("Nhap ma xac minh!");
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spVerifyPassword(@RequestBody CRUDUserRequest1 w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = userService.spVerifyPassword(w);
		response.setData(new UserResponseUpdatePassword(user));
		response.setMessageError("Success");
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
