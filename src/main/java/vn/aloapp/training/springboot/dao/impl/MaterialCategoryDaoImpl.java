package vn.aloapp.training.springboot.dao.impl;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.MaterialCategoryDao;
import vn.aloapp.training.springboot.entity.MeterialCategoryEntity;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialCategoryRequest;

@Repository("meterialCategoryDao")
public class MaterialCategoryDaoImpl extends AbstractDao<Integer, MeterialCategoryEntity>
		implements MaterialCategoryDao {

	@Override
	public MeterialCategoryEntity spUCreateMeterialCategory(int user_id, CRUDMeterialCategoryRequest u) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_category", MeterialCategoryEntity.class)
				.registerStoredProcedureParameter("user_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sort", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("user_id", user_id);
		query.setParameter("name", u.getName());
		query.setParameter("description", u.getDescription());
		query.setParameter("sort", u.getSort());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (MeterialCategoryEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public MeterialCategoryEntity spUpdateMeterialCategory(int id, int user_id, CRUDMeterialCategoryRequest u) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_update_category", MeterialCategoryEntity.class)
				.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("user_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("id", id);
		query.setParameter("user_id",user_id);
		query.setParameter("name", u.getName());
		query.setParameter("description", u.getDescription());
	

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (MeterialCategoryEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public MeterialCategoryEntity findById(int id) throws Exception {
		return (MeterialCategoryEntity) this.getSession()
				.createCriteria(MeterialCategoryEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();

	}
	@SuppressWarnings("deprecation")
	@Override
	public MeterialCategoryEntity findByName(String name) throws Exception {
		return (MeterialCategoryEntity) this.getSession()
				.createCriteria(MeterialCategoryEntity.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
	}

	@Override
	public void updateStatus(CRUDMeterialCategoryRequest m) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateStatusCategory(int id, int status) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_category_status", MeterialCategoryEntity.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status", Integer.class, ParameterMode.IN)	
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);
		query.setParameter("status",status);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			break;
			//return (MeterialCategoryEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public MeterialCategoryEntity findUserId(int userId) {
		return (MeterialCategoryEntity) this.getSession()
				.createCriteria(MeterialCategoryEntity.class)
				.add(Restrictions.eq("userId", userId))
				.uniqueResult();
	}

	@Override
	public MeterialCategoryEntity getUserId(int userId) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_get_userId_category", MeterialCategoryEntity.class)
				.registerStoredProcedureParameter("user_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("user_id",userId);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (MeterialCategoryEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public MeterialCategoryEntity getNameCategory(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
