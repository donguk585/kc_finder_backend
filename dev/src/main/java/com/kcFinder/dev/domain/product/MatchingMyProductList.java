package com.kcFinder.dev.domain.product;

import com.kcFinder.dev.web.dto.product.MatchingMyProductListRespDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchingMyProductList {

	private int product_code;
	private String product_name;
	private int user_code;
	private String product_img_path;
	
	public MatchingMyProductListRespDto toDto() {
		return MatchingMyProductListRespDto.builder()
				.userProductCode(product_code)
				.userProductName(product_name)
				.userCode(user_code)
				.userProductImgPath(product_img_path)
				.build();
	}
}
