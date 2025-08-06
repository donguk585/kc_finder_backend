package com.kcFinder.dev.domain.admin.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserProductRepository {

	public List<AdminUserProduct> adminUserProducts() throws Exception;
	
}
