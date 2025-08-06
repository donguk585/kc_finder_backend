package com.kcFinder.dev.web.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchingMyProductPlusListRespDto {

	private int matchingProductCode;
	private String kcCertificationNum;
	private String matchingProductLink;
	private String matchingKcImgUrl;
}
