package com.kcFinder.dev.web.dto.admin.product;

import com.kcFinder.dev.domain.admin.product.AdminUserProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminInsertMatchingProductReqDto {
	private int productCode;
	private String kcCertificationNum;
	private String matchingProductLink;
	private String matchingKcImgUrl;
	
	public AdminUserProduct toEntity() {
		return AdminUserProduct.builder()
				.product_code(productCode)
				.kc_certification_num(kcCertificationNum)
				.matching_product_link(matchingProductLink)
				.matching_kc_img_url(matchingKcImgUrl)
				.build();
	}
}
