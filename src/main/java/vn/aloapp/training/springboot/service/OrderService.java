package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.OrderDataModel;
import vn.aloapp.training.springboot.request.Orders.CRUDOrderRequest;

public interface OrderService {
	OrderDataModel spUCreateOrder(int userId, String listMaterial, CRUDOrderRequest w) throws Exception;

	OrderDataModel spUCreateOrderDebit(int userId, String listMaterial, CRUDOrderRequest w) throws Exception;

	OrderDataModel spUCreateOrderReturn(int userId, String listMaterial, CRUDOrderRequest w) throws Exception;

}
