package com.kcFinder.dev.service.user;

import org.springframework.stereotype.Service;

import com.kcFinder.dev.domain.user.SignUserRepository;
import com.kcFinder.dev.domain.user.User;
import com.kcFinder.dev.web.dto.user.SigninReqDto;
import com.kcFinder.dev.web.dto.user.SignupUserReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUserServiceImpl implements SignUserService{
	
	private final SignUserRepository signUserRepository;
	
	@Override
	public int saveSignupUser(SignupUserReqDto signupUserReqDto) throws Exception {
		// TODO Auto-generated method stub
		
		User user = signupUserReqDto.toEntity();
		
		if(signUserRepository.saveSignupUser(user) > 0) {
			return user.getUser_code();
		} else {
			return 0;
		}
		
	}

	@Override
	public int signinUser(SigninReqDto signinReqDto) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User();
		
		user = signUserRepository.findUserByUserId(signinReqDto.getUserId());
//    	System.out.println(user);
    	if(user == null) {
    		return 0;
    	}else {
    		if(user.getUser_id().equals(signinReqDto.getUserId()) && user.getUser_pw().equals(signinReqDto.getUserPassword())) {
    			return user.getUser_code();
    		}else {
    			return -1;
    		}
    	}
	}

}
