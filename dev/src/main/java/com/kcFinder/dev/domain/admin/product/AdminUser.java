package com.kcFinder.dev.domain.admin.product;

import com.kcFinder.dev.web.dto.admin.product.AdminUserRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser {

	private int user_code;
	private String user_id;
	private String user_pw;
	private String user_email;
	private String user_phone;

	
	public AdminUserRespDto toDto() {
		return AdminUserRespDto.builder()
				.userCode(user_code)
				.userId(user_id)
				.userPw(user_pw)
				.userEmail(user_email)
				.userPhone(user_phone)
				.build();
	}
	
}
