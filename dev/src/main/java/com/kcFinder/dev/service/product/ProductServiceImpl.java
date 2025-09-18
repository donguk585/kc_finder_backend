package com.kcFinder.dev.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kcFinder.dev.domain.product.MatchingMyProductList;
import com.kcFinder.dev.domain.product.MatchingMyProductPlusList;
import com.kcFinder.dev.domain.product.UserProduct;
import com.kcFinder.dev.domain.product.UserProductFile;
import com.kcFinder.dev.domain.product.UserProductRepository;
import com.kcFinder.dev.web.dto.product.MatchingMyProductListRespDto;
import com.kcFinder.dev.web.dto.product.MatchingMyProductPlusListRespDto;
import com.kcFinder.dev.web.dto.product.PaginationDto;
import com.kcFinder.dev.web.dto.product.ProductDetailDto;
import com.kcFinder.dev.web.dto.product.ProductFileReqDto;
import com.kcFinder.dev.web.dto.product.ProductListRespDto;
import com.kcFinder.dev.web.dto.product.ProductReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final UserProductRepository userProductRepository;
	
	@Override
	public int productUpload(ProductReqDto productReqDto) throws Exception {
		// TODO Auto-generated method stub
		UserProduct userProduct = productReqDto.toEntity();
//		System.out.println(userProduct);
		
		if(userProductRepository.insertUserProduct(userProduct) > 0) {
			return userProduct.getProduct_code();
		} else {
			return 0;
		}
	}

	@Override
	public boolean productFileUpload(List<ProductFileReqDto> productFileReqDtos) throws Exception {
        // TODO Auto-generated method stub
        
        // 업로드된 파일이 없는 경우 false를 반환
        if (productFileReqDtos == null || productFileReqDtos.isEmpty()) {
            return false;
        }

        // 리스트를 순회하며 각 DTO를 처리
        for (ProductFileReqDto productFileReqDto : productFileReqDtos) {
            UserProductFile userProductFile = productFileReqDto.toEntity();
//            System.out.println(userProductFile);

            // 레포지토리의 메서드를 호출하여 데이터 삽입
            // 삽입이 실패하면 즉시 false를 반환하고 루프를 종료합니다.
            if (userProductRepository.insertUserProductFile(userProductFile) <= 0) {
                return false;
            }
        }
        
        // 모든 파일이 성공적으로 처리되면 true를 반환
        return true;
	}

	@Override
	public List<MatchingMyProductListRespDto> findMyProductListByUserCode(int userCode) throws Exception {
		// TODO Auto-generated method stub
		List<MatchingMyProductList> matchingMyProductLists = new ArrayList<>();
		List<MatchingMyProductListRespDto> matchingProductListRespDtos = new ArrayList<>();
		
		matchingMyProductLists = userProductRepository.matchingMyProductList(userCode);
//		System.out.println(matchingMyProductLists);
		for(MatchingMyProductList matchingMyProductList : matchingMyProductLists) {
			
			MatchingMyProductListRespDto matchingMyProductListRespDto = new MatchingMyProductListRespDto();
		
			matchingMyProductListRespDto = matchingMyProductList.toDto();
			
			matchingProductListRespDtos.add(matchingMyProductListRespDto);
		}
		
		
		return matchingProductListRespDtos;
	}

	@Override
	public List<MatchingMyProductPlusListRespDto> findMyProductPlusListByUserCode(int userCode, int productCode)
			throws Exception {
		// TODO Auto-generated method stub
		List<MatchingMyProductPlusList> matchingMyProductPlusLists = new ArrayList<>();
		List<MatchingMyProductPlusListRespDto> matchingMyProductPlusListRespDtos = new ArrayList<>();
		
		matchingMyProductPlusLists = userProductRepository.matchingMyProductPlusList(userCode, productCode);
//		System.out.println(matchingMyProductPlusLists);
		for(MatchingMyProductPlusList matchingMyProductPlusList : matchingMyProductPlusLists) {
			
			MatchingMyProductPlusListRespDto matchingMyProductListRespDto = new MatchingMyProductPlusListRespDto();
		
			matchingMyProductListRespDto = matchingMyProductPlusList.toDto();
			
			matchingMyProductPlusListRespDtos.add(matchingMyProductListRespDto);
		}
		
		
		return matchingMyProductPlusListRespDtos;
	}

	@Override
	public ProductListRespDto getAllProducts(int page) throws Exception {
		int PAGE_SIZE = 5;
        try {
            // 페이지 번호는 1부터 시작하므로 0-based로 변환
            int offset = (page - 1) * PAGE_SIZE;
            
            // 전체 상품 수 조회
            int totalCount = userProductRepository.getTotalProductCount();
            int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE);
            boolean hasNext = page < totalPages;
            
            // 상품 목록 조회
            List<ProductDetailDto> products = userProductRepository.getAllProducts(offset, PAGE_SIZE);
            System.out.println(products);
            // 페이지네이션 정보 생성
            PaginationDto pagination = PaginationDto.builder()
                    .currentPage(page)
                    .totalPage(totalPages)
                    .size(PAGE_SIZE)
                    .hasNext(hasNext)
                    .build();
            
            return ProductListRespDto.builder()
                    .items(products)
                    .pagination(pagination)
                    .build();
                    
        } catch (Exception e) {
            throw new RuntimeException("상품 목록 조회 중 오류가 발생했습니다.", e);
        }
    }

	@Override
	public ProductListRespDto getProductsByUser(int userCode, int page) throws Exception {
		int PAGE_SIZE = 5;
        try {
            // 페이지 번호는 1부터 시작하므로 0-based로 변환
            int offset = (page - 1) * PAGE_SIZE;
            
            // 특정 유저의 상품 수 조회
            int totalCount = userProductRepository.getTotalProductCountByUser(userCode);
            int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE);
            boolean hasNext = page < totalPages;
            
            // 특정 유저의 상품 목록 조회
            List<ProductDetailDto> products = userProductRepository.getProductsByUser(userCode, offset, PAGE_SIZE);
            
            // 페이지네이션 정보 생성
            PaginationDto pagination = PaginationDto.builder()
                    .currentPage(page)
                    .totalPage(totalPages)
                    .size(PAGE_SIZE)
                    .hasNext(hasNext)
                    .build();
            
            return ProductListRespDto.builder()
                    .items(products)
                    .pagination(pagination)
                    .build();
                    
        } catch (Exception e) {
            throw new RuntimeException("유저 상품 목록 조회 중 오류가 발생했습니다.", e);
        }
    }


}
