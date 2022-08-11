package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.OrderDao;
import vn.aloapp.training.springboot.entity.OrderDataModel;
import vn.aloapp.training.springboot.request.Orders.CRUDOrderRequest;
import vn.aloapp.training.springboot.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;
	
	@Override
	public OrderDataModel spUCreateOrder(int userId, String listMaterial, CRUDOrderRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateOrder(userId, listMaterial, w);
	}

	@Override
	public OrderDataModel spUCreateOrderDebit(int userId, String listMaterial, CRUDOrderRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateOrderDebit(userId, listMaterial, w);
	}

	@Override
	public OrderDataModel spUCreateOrderReturn(int userId, String listMaterial, CRUDOrderRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateOrderReturn(userId, listMaterial, w);
	}

}
