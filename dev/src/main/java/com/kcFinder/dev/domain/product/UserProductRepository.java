package com.kcFinder.dev.domain.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProductRepository {
	
	public int insertUserProduct(UserProduct userProduct) throws Exception;
	
	public int insertUserProductFile(UserProductFile userProductFile) throws Exception;
	
	public List<MatchingMyProductList> matchingMyProductList(int userCode) throws Exception;
	
	public List<MatchingMyProductPlusList> matchingMyProductPlusList(@Param("userCode") int userCode, @Param("productCode") int productCode) throws Exception;
}
