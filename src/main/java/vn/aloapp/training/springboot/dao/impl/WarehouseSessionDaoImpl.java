package vn.aloapp.training.springboot.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.WarehouseSessionDao;
import vn.aloapp.training.springboot.entity.WareHouseSessionEntity;
import vn.aloapp.training.springboot.entity.WarehouseDataModel;
import vn.aloapp.training.springboot.request.WareHouseSession.CRUDWarehouseSessionRequest;


@Repository("warehousesessionDao")
public class WarehouseSessionDaoImpl extends AbstractDao<Integer, WareHouseSessionEntity> implements WarehouseSessionDao {

	@Override
	public List<WareHouseSessionEntity> findAllWarehouseSession() throws Exception {
		CriteriaQuery<WareHouseSessionEntity> criteria = this.getBuilder().createQuery(WareHouseSessionEntity.class);
		Root<WareHouseSessionEntity> root = criteria.from(WareHouseSessionEntity.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public WarehouseDataModel spUCreateWarehouseSessionExprot(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_export_warehouse_session", WarehouseDataModel.class)
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
			return (WarehouseDataModel) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public WarehouseDataModel spUCreateWarehouseSessionImport(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_import_warehouse_session", WarehouseDataModel.class)
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
			return (WarehouseDataModel) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public WarehouseDataModel spUCreateWarehouseSessionReturn(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_return_warehouse_session", WarehouseDataModel.class)
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
			return (WarehouseDataModel) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public WarehouseDataModel spUCreateWarehouseSessionCancel(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_cancel_warehouse_session", WarehouseDataModel.class)
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
			return (WarehouseDataModel) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public WareHouseSessionEntity spUCreateWarehouseSessionImport1(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_import_warehouse_session", WareHouseSessionEntity.class)
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
			return (WareHouseSessionEntity) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}
