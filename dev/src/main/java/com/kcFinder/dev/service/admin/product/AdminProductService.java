package com.kcFinder.dev.service.admin.product;

import java.util.List;

import com.kcFinder.dev.web.dto.admin.product.AdminInsertMatchingProductReqDto;
import com.kcFinder.dev.web.dto.admin.product.AdminUserProductRespDto;


public interface AdminProductService {

	public List<AdminUserProductRespDto> findProductListForAdmin() throws Exception;
	
	public boolean insertMatchingProduct(AdminInsertMatchingProductReqDto adminInsertMatchingProductReqDto) throws Exception;
}
