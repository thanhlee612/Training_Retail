package vn.aloapp.training.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.UserDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.CRUDUserRequest1;
import vn.aloapp.training.springboot.request.CRUDUserRequest;
import vn.aloapp.training.springboot.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public UserEntity spUCreateUser(CRUDUserRequest user) throws Exception {
		return dao.spUCreateUser(user);
	}

	@Override
	public UserEntity spGetUserById(int id) throws Exception {
		return dao.spGetUserById(id);
	}

	@Override
	public StoreProcedureListResult<UserEntity> spGetAllUser(int expire) throws Exception {
		return dao.spGetAllUser(expire);
	}

	@Override
	public void spUpdateUser(int id, CRUDUserRequest u) throws Exception {
		dao.spUpdateUser(id, u);
	}

	@Override
	public void spDedeteUser(int id) throws Exception {
		dao.spDedeteUser(id);
	}

	@Override
	public StoreProcedureListResult<UserEntity> search(String keyword) throws Exception {
		return dao.search(keyword);
	}

	@Override
	public UserEntity spLoginUser(int id, CRUDUserRequest1 w) throws Exception {
		return dao.spLoginUser(id, w);
	}

	@Override
	public UserEntity spChangePassword(int id, CRUDUserRequest1 w) throws Exception {
		return dao.spChangePassword(id, w);
	}

	@Override
	public UserEntity spForgotPassword(CRUDUserRequest1 w) throws Exception {
		return dao.spForgotPassword(w);
	}

	@Override
	public UserEntity spVerifyPassword(CRUDUserRequest1 w) throws Exception {
		return dao.spVerifyPassword(w);
	}

	@Override
	public UserEntity findOne(int id) {
		return dao.findOne(id);
	}


}
