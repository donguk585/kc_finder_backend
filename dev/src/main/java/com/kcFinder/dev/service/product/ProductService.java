package com.kcFinder.dev.service.product;

import java.util.List;

import com.kcFinder.dev.web.dto.product.MatchingMyProductListRespDto;
import com.kcFinder.dev.web.dto.product.MatchingMyProductPlusListRespDto;
import com.kcFinder.dev.web.dto.product.ProductFileReqDto;
import com.kcFinder.dev.web.dto.product.ProductListRespDto;
import com.kcFinder.dev.web.dto.product.ProductReqDto;

public interface ProductService {

	public int productUpload(ProductReqDto productReqDto) throws Exception;
	
	public boolean productFileUpload(List<ProductFileReqDto> productFileReqDtos) throws Exception;
	
	public List<MatchingMyProductListRespDto> findMyProductListByUserCode(int userCode) throws Exception;
	
	public List<MatchingMyProductPlusListRespDto> findMyProductPlusListByUserCode(int userCode, int productCode) throws Exception;
	
	public ProductListRespDto getAllProducts(int page) throws Exception;
	
	public ProductListRespDto getProductsByUser(int userCode, int page) throws Exception;
}
