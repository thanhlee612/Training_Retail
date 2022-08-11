package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.OrderDataModel;
import vn.aloapp.training.springboot.request.Orders.CRUDOrderRequest;

public interface OrderDao {
	OrderDataModel spUCreateOrder(int userId, String listMaterial, CRUDOrderRequest w) throws Exception;

	OrderDataModel spUCreateOrderDebit(int userId, String listMaterial, CRUDOrderRequest w) throws Exception;

	OrderDataModel spUCreateOrderReturn(int userId, String listMaterial, CRUDOrderRequest w) throws Exception;

}
