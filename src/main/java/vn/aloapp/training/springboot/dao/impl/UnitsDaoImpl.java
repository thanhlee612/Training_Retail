package vn.aloapp.training.springboot.dao.impl;

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
import vn.aloapp.training.springboot.dao.UnitsDao;
import vn.aloapp.training.springboot.entity.UnitEntity;

@Repository("unitDao")
public class UnitsDaoImpl extends AbstractDao<Integer, UnitEntity> implements UnitsDao {

	@Override
	public UnitEntity spUCreateUnit(int user_id, String name, String description) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_create_unit", UnitEntity.class)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("user_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("name", name);
		query.setParameter("user_id", user_id);
		query.setParameter("description", description);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UnitEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public UnitEntity spUdateUnit(int id, int user_id, String name, String description) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_update_unit", UnitEntity.class)
				.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("user_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("id", id);
		query.setParameter("user_id", user_id);
		query.setParameter("name", name);
		query.setParameter("description", description);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UnitEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public UnitEntity findById(int id) throws Exception {
		return (UnitEntity) this.getSession()
				.createCriteria(UnitEntity.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public UnitEntity findByName(String name) throws Exception {
		return (UnitEntity) this.getSession()
				.createCriteria(UnitEntity.class)
				.add(Restrictions.eq("name", name))
				.uniqueResult();
	}

	@Override
	public List<UnitEntity> findAll() throws Exception {
		CriteriaQuery<UnitEntity> criteria = this.getBuilder().createQuery(UnitEntity.class);
		Root<UnitEntity> root = criteria.from(UnitEntity.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}

	@Override
	public void updateStatusUnit(int id, int status) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_unit_status", UnitEntity.class)
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
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}

}
