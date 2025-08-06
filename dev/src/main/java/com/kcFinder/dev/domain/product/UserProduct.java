package com.kcFinder.dev.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProduct {
	
	private int product_code;
	private int user_code;
	private String product_name;
}
