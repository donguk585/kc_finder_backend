package com.kcFinder.dev.domain.admin.product;

import com.kcFinder.dev.web.dto.admin.product.AdminUserProductRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserProduct {

	private int user_code;
	private String user_id;
	private int product_code;
	private String product_name;
	private String product_img_path;
	private int matching_product_code;
	private String kc_certification_num;
	private String matching_product_link;
	private int matching_product_img_code;
	private String matching_kc_img_url;
	
	public AdminUserProductRespDto toDto() {
		return AdminUserProductRespDto.builder()
				.userCode(user_code)
				.userId(user_id)
				.productCode(product_code)
				.productName(product_name)
				.productImgPath(product_img_path)
				.matchingProductCode(matching_product_code)
				.kcCertificationNum(kc_certification_num)
				.matchingProductLink(matching_product_link)
				.matchingKcImgUrl(matching_kc_img_url)
				.build();
	}
}
