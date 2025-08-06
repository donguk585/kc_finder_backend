package com.kcFinder.dev.web.dto.admin.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserProductRespDto {

	private int userCode;
	private String userId;
	private int productCode;
	private String productName;
	private String productImgPath;
	private int matchingProductCode;
	private String kcCertificationNum;
	private String matchingProductLink;
	private String matchingKcImgUrl;
}
