package com.kcFinder.dev.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SigninReqDto {
	
	private String userId;
	private String userPassword;

}