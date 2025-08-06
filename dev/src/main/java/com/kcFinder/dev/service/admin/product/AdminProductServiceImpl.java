package com.kcFinder.dev.service.admin.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kcFinder.dev.domain.admin.product.AdminUserProduct;
import com.kcFinder.dev.domain.admin.product.AdminUserProductRepository;
import com.kcFinder.dev.web.dto.admin.product.AdminUserProductRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {
	
	private final AdminUserProductRepository adminUserProductRepository;
	
	@Override
	public List<AdminUserProductRespDto> findProductListForAdmin() throws Exception {
		// TODO Auto-generated method stub
		List<AdminUserProduct> adminUserProducts = new ArrayList<>();
		List<AdminUserProductRespDto> adminUserProductRespDtos = new ArrayList<>();
		
		adminUserProducts = adminUserProductRepository.adminUserProducts();
//		System.out.println(adminUserProducts);
		for(AdminUserProduct adminUserProduct : adminUserProducts) {
			
			AdminUserProductRespDto adminUserProductRespDto = new AdminUserProductRespDto();
		
			adminUserProductRespDto = adminUserProduct.toDto();
			
			adminUserProductRespDtos.add(adminUserProductRespDto);
		}
		
		
		return adminUserProductRespDtos;
	}

}
