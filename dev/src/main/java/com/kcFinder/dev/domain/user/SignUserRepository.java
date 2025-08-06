package com.kcFinder.dev.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignUserRepository {

	public int saveSignupUser(User user) throws Exception;
	
	public User findUserByUserId(String user_id) throws Exception;
}
