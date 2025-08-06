package com.kcFinder.dev.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	private int user_code;
	private String user_id;
	private String user_pw;
	private String user_email;
	private String user_phone;
	
}
