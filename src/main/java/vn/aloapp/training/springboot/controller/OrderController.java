package vn.aloapp.training.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.entity.OrderDataModel;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.Orders.CRUDOrderRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.Orders.OrderResponse;
import vn.aloapp.training.springboot.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends BaseController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/create-order", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createOrder(@RequestHeader("Authorization") String token,
			@RequestBody CRUDOrderRequest wrapper) throws Exception {
//		BaseResponse response = new BaseResponse();
//		UserEntity user = this.accessToken(token);
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(wrapper.getListMaterialDetail());
//		OrderDataModel orderEntity = orderService.spUCreateOrder(user.getId(), json, wrapper);
//		response.setData(new OrderResponse(orderEntity));
//		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (user != null) {
				String json = mapper.writeValueAsString(wrapper.getListMaterialDetail());
				OrderDataModel orderEntity = orderService.spUCreateOrder(user.getId(), json, wrapper);	
				response.setData(new OrderResponse(orderEntity));
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessageError("token không đúng");
			}
		} 
		catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/create-order-debit", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createOrderDebit(@RequestHeader("Authorization") String token,
			@RequestBody CRUDOrderRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(wrapper.getListMaterialDetail());
		OrderDataModel orderEntity = orderService.spUCreateOrderDebit(user.getId(), json, wrapper);
		response.setData(new OrderResponse(orderEntity));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create-order-return", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createOrderReturn(@RequestHeader("Authorization") String token,
			@RequestBody CRUDOrderRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(wrapper.getListMaterialDetail());
		OrderDataModel orderEntity = orderService.spUCreateOrderReturn(user.getId(), json, wrapper);
		response.setData(new OrderResponse(orderEntity));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
