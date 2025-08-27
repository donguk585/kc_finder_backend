package com.kcFinder.dev.domain.admin.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserProductRepository {

	public List<AdminUser> adminUsers() throws Exception;
	
	public List<AdminUserProduct> adminUserProducts() throws Exception;
	
	public int adminInsertMatchingProduct(AdminUserProduct adminUserProduct) throws Exception;
	
	public int adminInsertMatchingProductUrl(AdminUserProduct adminUserProduct) throws Exception;
	
}
