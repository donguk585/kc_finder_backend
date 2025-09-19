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
		System.out.println(signinReqDto);
    	System.out.println(user);
        // 사용자 정보가 존재하지 않을 경우 예외 발생
        if (user == null) {
            throw new Exception("존재하지 않는 사용자 ID입니다.");
        }

        // 비밀번호가 일치하지 않을 경우 예외 발생
        if (!user.getUser_pw().equals(signinReqDto.getUserPassword())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        return user.getUser_code();
	}

	@Override
	public boolean checkUserIdAvailability(String userId) throws Exception {
        try {
            // DB에서 해당 userId 개수 조회
            int count = signUserRepository.countByUserId(userId);
            
            // count가 0이 아니면 중복된 아이디가 있다는 뜻이므로 에러 throw
            if (count != 0) {
                throw new RuntimeException("이미 사용 중인 아이디입니다.");
            }
            
            // count가 0이면 사용 가능
            return true;
            
        } catch (Exception e) {
            throw new RuntimeException("중복된 아이디가 있습니다.", e);
        }
    }

}
