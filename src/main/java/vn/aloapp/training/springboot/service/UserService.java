package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.CRUDUserRequest1;
import vn.aloapp.training.springboot.request.CRUDUserRequest;

public interface UserService {
	UserEntity spUCreateUser(CRUDUserRequest user) throws Exception;
	
	UserEntity spGetUserById(int id) throws Exception;
	
	StoreProcedureListResult<UserEntity> spGetAllUser(int expire) throws Exception;
	
	void spUpdateUser(int id, CRUDUserRequest u) throws Exception;
	
	void spDedeteUser(int id) throws Exception;
	
	StoreProcedureListResult<UserEntity> search(String keyword) throws Exception;
	
	UserEntity spLoginUser(int id, CRUDUserRequest1 w) throws Exception;
	
	UserEntity spChangePassword(int id, CRUDUserRequest1 w) throws Exception;
	
	UserEntity spForgotPassword(CRUDUserRequest1 w) throws Exception;
	
	UserEntity spVerifyPassword(CRUDUserRequest1 w) throws Exception;
	
	UserEntity findOne(int id);
	
}
