package com.kcFinder.dev.service.user;

import com.kcFinder.dev.web.dto.user.SigninReqDto;
import com.kcFinder.dev.web.dto.user.SignupUserReqDto;

public interface SignUserService {

	public int saveSignupUser(SignupUserReqDto signupUserReqDto) throws Exception;
	
	public int signinUser(SigninReqDto signinReqDto) throws Exception;
}
