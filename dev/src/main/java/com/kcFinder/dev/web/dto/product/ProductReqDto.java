package com.kcFinder.dev.web.dto.product;


import com.kcFinder.dev.domain.product.UserProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductReqDto {

	private int userCode;
	private String productName;
	
	
	public UserProduct toEntity() {
		return UserProduct.builder()
				.user_code(userCode)
				.product_name(productName)
				.build();
	}
}
