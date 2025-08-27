package com.kcFinder.dev.service.admin.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kcFinder.dev.domain.admin.product.AdminUser;
import com.kcFinder.dev.domain.admin.product.AdminUserProduct;
import com.kcFinder.dev.domain.admin.product.AdminUserProductRepository;
import com.kcFinder.dev.web.dto.admin.product.AdminInsertMatchingProductReqDto;
import com.kcFinder.dev.web.dto.admin.product.AdminUserProductRespDto;
import com.kcFinder.dev.web.dto.admin.product.AdminUserRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {
	
	private final AdminUserProductRepository adminUserProductRepository;
	
	@Override
	public List<AdminUserRespDto> findUserListForAdmin() throws Exception {
		// TODO Auto-generated method stub
		List<AdminUser> adminUsers = new ArrayList<>();
		List<AdminUserRespDto> adminUserRespDtos = new ArrayList<>();
		
		adminUsers = adminUserProductRepository.adminUsers();
		for(AdminUser adminUser : adminUsers) {
			
			AdminUserRespDto adminUserProductRespDto = new AdminUserRespDto();
		
			adminUserProductRespDto = adminUser.toDto();
			
			adminUserRespDtos.add(adminUserProductRespDto);
		}
		
		
		return adminUserRespDtos;
	}
	
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
	@Override
	public boolean insertMatchingProduct(AdminInsertMatchingProductReqDto adminInsertMatchingProductReqDto) throws Exception {

	    AdminUserProduct adminUserProduct = adminInsertMatchingProductReqDto.toEntity();

	    // 1. matching_product 테이블에 기본 정보 삽입
	    // 이 메서드 호출 후, adminUserProduct의 product_code에 새로 생성된 PK가 할당됩니다.
	    if(adminUserProductRepository.adminInsertMatchingProduct(adminUserProduct) > 0) {
	        
	        // 2. 문자열로 된 URL을 '\n\n' 기준으로 분리하여 리스트로 변환
	        String matchingKcImgUrlStr = adminUserProduct.getMatching_kc_img_url();
	        List<String> matchingKcImgUrls = new ArrayList<>();
	        if (matchingKcImgUrlStr != null && !matchingKcImgUrlStr.trim().isEmpty()) {
	            // trim()으로 공백 제거 후, split()으로 분리
	            String[] urls = matchingKcImgUrlStr.split("\n\n"); 
	            for (String url : urls) {
	                // 각 URL의 앞뒤 공백을 제거하고 리스트에 추가
	                if (!url.trim().isEmpty()) {
	                    matchingKcImgUrls.add(url.trim());
	                }
	            }
	        }
	        
	        // 3. 변환된 URL 리스트를 순회하며 개별 삽입
	        if (matchingKcImgUrls.isEmpty()) {
	            // URL이 없으면 등록 실패로 간주
	            throw new Exception("매칭 사진 URL이 없습니다."); 
	        }

	        int successCount = 0;
	        for (String url : matchingKcImgUrls) {
	            // Mybatis 매퍼에 전달할 객체 생성 (product_code는 기존 값 재사용)
	            AdminUserProduct urlEntity = new AdminUserProduct();
	            urlEntity.setMatching_product_code(adminUserProduct.getMatching_product_code());
	            urlEntity.setMatching_kc_img_url(url);
	            
	            // 각 URL을 별도의 행으로 삽입
	            if (adminUserProductRepository.adminInsertMatchingProductUrl(urlEntity) > 0) {
	                successCount++;
	            }
	        }
	        
	        // 삽입된 URL의 수가 전체 URL의 수와 같으면 성공
	        if (successCount == matchingKcImgUrls.size()) {
	            return true;
	        }
	    }
	    
	    return false;
	}


}