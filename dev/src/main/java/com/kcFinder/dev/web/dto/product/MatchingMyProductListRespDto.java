package com.kcFinder.dev.web.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchingMyProductListRespDto {

	private int userProductCode;
	private String userProductName;
	private int userCode;
	private String userProductImgPath;
}
