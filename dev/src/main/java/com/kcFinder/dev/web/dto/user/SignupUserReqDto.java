package com.kcFinder.dev.web.dto.user;

import com.kcFinder.dev.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupUserReqDto {

	private String userId;
	private String userPassword;
	private String userEmail;
	private String userPhone;
	
	
	public User toEntity() {
		return User.builder()
				.user_id(userId)
				.user_pw(userPassword)
				.user_email(userEmail)
				.user_phone(userPhone)
				.build();
	}
}
