package vn.aloapp.training.springboot.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.MaterialDao;
import vn.aloapp.training.springboot.entity.MaterialEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialRequest;

@Repository("meterialDao")
public class MaterialDaoImpl extends AbstractDao<Integer, MaterialEntity> implements MaterialDao {

	@Override
	public MaterialEntity spCreateMeterial(int userId, CRUDMeterialRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_meterial", MaterialEntity.class)
				.registerStoredProcedureParameter("userId",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("_name",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("_avatar",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("_avatarThump",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("categoryId",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("unitId",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("wastageRate",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("outStockAlertQuantity",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("retailPrice",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("costPrice",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		
		query.setParameter("userId", userId);
		query.setParameter("_name", w.getName());
		query.setParameter("_avatar", w.getAvatar());
		query.setParameter("_avatarThump", w.getAvatarThump());
		query.setParameter("categoryId", w.getCategoryId());
		query.setParameter("unitId", w.getUnitId());
		query.setParameter("wastageRate", w.getWastageRate());
		query.setParameter("outStockAlertQuantity", w.getOutStockAlertQuantity());
		query.setParameter("retailPrice", w.getRetailPrice());
		query.setParameter("costPrice", w.getCostPrice());
		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (MaterialEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public MaterialEntity spUpdateMeterial(int id, int userId, CRUDMeterialRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_update_meterial", MaterialEntity.class)
				.registerStoredProcedureParameter("_id",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("userId",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("_name",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("_avatar",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("_avatarThump",String.class,ParameterMode.IN)
				.registerStoredProcedureParameter("categoryId",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("unitId",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("wastageRate",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("outStockAlertQuantity",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("retailPrice",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("costPrice",BigDecimal.class,ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);


		query.setParameter("_id",id);
		query.setParameter("userId", userId);
		query.setParameter("_name", w.getName());	
		query.setParameter("_avatar", w.getAvatar());
		query.setParameter("_avatarThump", w.getAvatarThump());
		query.setParameter("categoryId", w.getCategoryId());
		query.setParameter("unitId", w.getUnitId());
		query.setParameter("wastageRate", w.getWastageRate());
		query.setParameter("outStockAlertQuantity", w.getOutStockAlertQuantity());
		query.setParameter("retailPrice", w.getRetailPrice());
		query.setParameter("costPrice", w.getCostPrice());
		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (MaterialEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public MaterialEntity updateStatusMeterial(int id, int status) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_meterial_status", MaterialEntity.class)
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
			return (MaterialEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public MaterialEntity findById(int id) throws Exception {
		return (MaterialEntity) this.getSession()
				.createCriteria(MaterialEntity.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public MaterialEntity findByName(String name) throws Exception {
		return (MaterialEntity) this.getSession()
		.createCriteria(MaterialEntity.class)
		.add(Restrictions.eq("name", name))
		.uniqueResult();
	}

	@Override
	public List<MaterialEntity> findAll() throws Exception {
		CriteriaQuery<MaterialEntity> criteria = this.getBuilder().createQuery(MaterialEntity.class);
		Root<MaterialEntity> root = criteria.from(MaterialEntity.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<MaterialEntity> findByStatus(int status) throws Exception {
		return (List<MaterialEntity>) this.getSession()
				.createCriteria(MaterialEntity.class)
				.add(Restrictions.eq("status", status))
				.uniqueResult();
	}

	
	// get trang thai status
	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<MaterialEntity> getStatus(int status) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_get_status", MaterialEntity.class)
				.registerStoredProcedureParameter("status",Integer.class,ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("status", status);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<MaterialEntity>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}

}
