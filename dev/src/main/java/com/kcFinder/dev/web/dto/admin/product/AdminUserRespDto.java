package com.kcFinder.dev.web.dto.admin.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserRespDto {
	
	private int userCode;
	private String userId;
	private String userPw;
	private String userEmail;
	private String userPhone;
	
}
