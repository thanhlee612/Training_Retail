package vn.aloapp.training.springboot.dao.impl;

import java.math.BigDecimal;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.OrderDao;
import vn.aloapp.training.springboot.entity.OrderDataModel;
import vn.aloapp.training.springboot.entity.OrderEntity;
import vn.aloapp.training.springboot.request.Orders.CRUDOrderRequest;



@Repository("ordersDao")
public class OrderDaoImpl extends AbstractDao<Integer, OrderEntity> implements OrderDao {

	@SuppressWarnings("unchecked")
	@Override
	public OrderDataModel spUCreateOrder(int userId, String listMaterial, CRUDOrderRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_create_order", OrderDataModel.class)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter("vat", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("listMaterial", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", userId);
		query.setParameter("discountPercent", w.getDiscountPercent());
		query.setParameter("vat", w.getVat());
		query.setParameter("description", w.getDescription());
		query.setParameter("listMaterial", listMaterial);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (OrderDataModel) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrderDataModel spUCreateOrderDebit(int userId, String listMaterial, CRUDOrderRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_create_order_customer_debit", OrderDataModel.class)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("customerDebtId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter("vat", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("listMaterial", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", userId);
		query.setParameter("customerDebtId", w.getCustomerDebtId());
		query.setParameter("discountPercent", w.getDiscountPercent());
		query.setParameter("vat", w.getVat());
		query.setParameter("description", w.getDescription());
		query.setParameter("listMaterial", listMaterial);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (OrderDataModel) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrderDataModel spUCreateOrderReturn(int userId, String listMaterial, CRUDOrderRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_create_order_return", OrderDataModel.class)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter("vat", BigDecimal.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("listMaterial", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", userId);
		query.setParameter("discountPercent", w.getDiscountPercent());
		query.setParameter("vat", w.getVat());
		query.setParameter("description", w.getDescription());
		query.setParameter("listMaterial", listMaterial);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (OrderDataModel) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}
}
