package vn.aloapp.training.springboot.dao.impl;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.UserDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.CRUDUserRequest;
import vn.aloapp.training.springboot.request.CRUDUserRequest1;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity spUCreateUser(CRUDUserRequest u) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_user", UserEntity.class)
				.registerStoredProcedureParameter("first_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("last_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("gender", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("email", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("is_expire", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("avatar", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("ward_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("city_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("district_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("passwords", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("first_name", u.getFirstName());
		query.setParameter("last_name", u.getLastName());
		query.setParameter("gender", u.getGender());
		query.setParameter("email", u.getEmail());
		query.setParameter("is_expire", u.getIsExpire());
		query.setParameter("avatar", u.getAvatar());
		query.setParameter("ward_id", u.getWardId());
		query.setParameter("city_id", u.getCityId());
		query.setParameter("district_id", u.getDistrictId());
		query.setParameter("phone", u.getPhone());
		query.setParameter("passwords", u.getPassword());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UserEntity) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public UserEntity spGetUserById(int id) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_user_id", UserEntity.class)
				.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("id", id);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UserEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<UserEntity> spGetAllUser(int expire) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_get_user", UserEntity.class)
				.registerStoredProcedureParameter("is_expire", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("is_expire", expire);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<UserEntity>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void spUpdateUser(int id, CRUDUserRequest u) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_update_user", UserEntity.class)
				.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("first_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("last_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("gender", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("email", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("is_expire", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("avatar", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("ward_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("city_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("district_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("id", id);
		query.setParameter("first_name", u.getFirstName());
		query.setParameter("last_name", u.getLastName());
		query.setParameter("gender", u.getGender());
		query.setParameter("email", u.getEmail());
		query.setParameter("is_expire", u.getIsExpire());
		query.setParameter("avatar", u.getAvatar());
		query.setParameter("ward_id", u.getWardId());
		query.setParameter("city_id", u.getCityId());
		query.setParameter("district_id", u.getDistrictId());
		query.setParameter("phone", u.getPhone());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			query.getResultList().stream().findFirst().orElse(null);
			break;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}

	}

	@Override
	public void spDedeteUser(int id) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_delete_user", UserEntity.class)
				.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("id", id);
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

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<UserEntity> search(String keyword) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_search_user", UserEntity.class)
				.registerStoredProcedureParameter("_keyword", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_keyword", keyword);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<UserEntity>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity spLoginUser(int id, CRUDUserRequest1 w) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_user_login", UserEntity.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);
		query.setParameter("_phone", w.getPhone());
		query.setParameter("_password", w.getPassword());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UserEntity) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity spChangePassword(int id, CRUDUserRequest1 w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_change_password", UserEntity.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_newPassword", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_confirm", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);
		query.setParameter("_phone", w.getPhone());
		query.setParameter("_password", w.getPassword());
		query.setParameter("_newPassword", w.getNewPassword());
		query.setParameter("_confirm", w.getConfirm());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UserEntity) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public UserEntity spForgotPassword(CRUDUserRequest1 w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_forgot_password", UserEntity.class)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_newPassword", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_confirmPassword", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_phone", w.getPhone());
		query.setParameter("_newPassword", w.getNewPassword());
		query.setParameter("_confirmPassword", w.getConfirm());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UserEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public UserEntity spVerifyPassword(CRUDUserRequest1 w) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_verify_code", UserEntity.class)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_verify_code", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_phone", w.getPhone());
		query.setParameter("_verify_code", w.getVerifyCode());
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (UserEntity) query.getSingleResult();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public UserEntity findOne(int id) {
		return (UserEntity) this.getSession()
				.createCriteria(UserEntity.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	

}
