package com.kcFinder.dev.service.admin.product;

import java.util.List;

import com.kcFinder.dev.web.dto.admin.product.AdminUserProductRespDto;


public interface AdminProductService {

	public List<AdminUserProductRespDto> findProductListForAdmin() throws Exception;
}
