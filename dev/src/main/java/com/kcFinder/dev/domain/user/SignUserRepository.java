package com.kcFinder.dev.domain.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignUserRepository {

	public int saveSignupUser(User user) throws Exception;
	
	public User findUserByUserId(@Param("user_id") String user_id) throws Exception;
}
