package com.kcFinder.dev.web.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcFinder.dev.service.user.SignUserService;
import com.kcFinder.dev.web.dto.CMRespDto;
import com.kcFinder.dev.web.dto.user.SigninReqDto;
import com.kcFinder.dev.web.dto.user.SignupUserReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class SignUserController {

	private final SignUserService signUserService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> UserSignup(@RequestBody SignupUserReqDto signupUserReqDto) {
//		System.out.println(signupUserReqDto);
		int userCode = 0;
		
		try {
			userCode = signUserService.saveSignupUser(signupUserReqDto);
//			System.out.println(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "회원가입 실패",userCode));

		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입", userCode));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> UserSignin(@RequestBody SigninReqDto signinReqDto) {
		
		int UserCode = 0;
		
		try {
			UserCode = signUserService.signinUser(signinReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, e.getMessage(), null));

		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "로그인 성공", UserCode));
		
	}
	
	// 아이디 중복확인
    @GetMapping("/dup-check/{userId}")
    public ResponseEntity<?> checkDuplicateUserId(@PathVariable("userId") String userId) {
        try {
            boolean isAvailable = signUserService.checkUserIdAvailability(userId);
            return ResponseEntity.ok().body(new CMRespDto<>(1, "사용 가능한 아이디입니다.", isAvailable));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new CMRespDto<>(-1, e.getMessage(), false));
        }
    }
	
}
