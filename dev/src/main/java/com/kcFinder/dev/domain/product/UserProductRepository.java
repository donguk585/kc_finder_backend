package com.kcFinder.dev.domain.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kcFinder.dev.web.dto.product.ProductDetailDto;

@Mapper
public interface UserProductRepository {
	
	public int insertUserProduct(UserProduct userProduct) throws Exception;
	
	public int insertUserProductFile(UserProductFile userProductFile) throws Exception;
	
	public List<MatchingMyProductList> matchingMyProductList(int userCode) throws Exception;
	
	public List<MatchingMyProductPlusList> matchingMyProductPlusList(@Param("userCode") int userCode, @Param("productCode") int productCode) throws Exception;
	
    public List<ProductDetailDto> getAllProducts(@Param("offset") int offset, @Param("size") int size) throws Exception;
    
    public int getTotalProductCount() throws Exception;
    
    public List<String> getProductImages(@Param("product_code") int productCode) throws Exception;
    
    public List<String> getMatchingImages(@Param("matching_product_code") int matchingProductCode) throws Exception;
    
    public List<ProductDetailDto> getProductsByUser(@Param("userCode") int userCode, @Param("offset") int offset, @Param("size") int size) throws Exception;
    
    public int getTotalProductCountByUser(@Param("userCode") int userCode) throws Exception;
    
}
