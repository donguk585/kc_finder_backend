package com.kcFinder.dev.web.dto.product;

import com.kcFinder.dev.domain.product.UserProductFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductFileReqDto {
	private int productCode;
	private String imageUrl;
	
	
	public UserProductFile toEntity() {
		return UserProductFile.builder()
				.product_code(productCode)
				.product_img_path(imageUrl)
				.build();
	}
}
