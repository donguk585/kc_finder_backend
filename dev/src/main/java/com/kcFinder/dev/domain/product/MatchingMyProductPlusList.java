package com.kcFinder.dev.domain.product;

import com.kcFinder.dev.web.dto.product.MatchingMyProductListRespDto;
import com.kcFinder.dev.web.dto.product.MatchingMyProductPlusListRespDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchingMyProductPlusList {

	private int matching_product_code;
	private String kc_certification_num;
	private String matching_product_link;
	private String matching_kc_img_url;
	
	public MatchingMyProductPlusListRespDto toDto() {
		return MatchingMyProductPlusListRespDto.builder()
				.matchingProductCode(matching_product_code)
				.kcCertificationNum(kc_certification_num)
				.matchingProductLink(matching_product_link)
				.matchingKcImgUrl(matching_kc_img_url)
				.build();
	}
}
