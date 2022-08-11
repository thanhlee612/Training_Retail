/**
 * 
 */
package vn.aloapp.training.springboot.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.UserDataModel;
import vn.aloapp.training.springboot.service.UserService;

/**
 * @author kelvin
 *
 */

@RestController
public class BaseController {

	@Autowired
	private UserService userService;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<BaseResponse> handleUserNotFoundException(MethodArgumentNotValidException ex,
			WebRequest request) {

		BaseResponse response = new BaseResponse();
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setMessageError("Dữ liệu không hợp lệ");

		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

		response.setData(errors);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<BaseResponse> handleMissingParams(MissingServletRequestParameterException ex) {
		// Actual exception handling
		BaseResponse response = new BaseResponse();
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setMessageError(String.format("%s is required!", ex.getParameterName()));
		response.setData(null);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	public UserEntity accessToken(String token) throws Exception {
		byte[] asBytes = java.util.Base64.getDecoder().decode(token);
		String str = new String(asBytes, Charset.forName("UTF-8"));
		ObjectMapper mapper = new ObjectMapper();
		UserDataModel map = mapper.readValue(str, UserDataModel.class);
		UserEntity user = userService.findOne(map.getId());
		if (user != null) {
			return user;
		}
		throw new Exception("Error token");
	}

//	@SuppressWarnings("unused")
//	@Autowired
//	private UserService userService;
//
//	public User handleTokenAccess(String encodeString) throws Exception {
//
//		byte[] decodedBytes = Base64.getMimeDecoder().decode(encodeString);
//		String decodedMime = new String(decodedBytes);
//
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			UserClient map = mapper.readValue(decodedMime, UserClient.class);
//
//			User user = userService.findOne(map.getUserId());
//
//			if (user != null)
//				return user;
//			else
//				throw new Exception();
//
//		} catch (Exception e) {
//
//			throw new Exception("Sai token ,");
//
//		}
//
//	}

}
