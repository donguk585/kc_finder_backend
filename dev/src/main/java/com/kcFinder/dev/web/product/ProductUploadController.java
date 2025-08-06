package com.kcFinder.dev.web.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcFinder.dev.service.product.ProductService;
import com.kcFinder.dev.web.dto.CMRespDto;
import com.kcFinder.dev.web.dto.product.MatchingMyProductListRespDto;
import com.kcFinder.dev.web.dto.product.MatchingMyProductPlusListRespDto;
import com.kcFinder.dev.web.dto.product.ProductFileReqDto;
import com.kcFinder.dev.web.dto.product.ProductReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductUploadController {

	private final ProductService productService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> ProductUpload(@RequestBody ProductReqDto productReqDto) {
//		System.out.println(productReqDto);
		int productCode = 0;
		
		try {
			productCode = productService.productUpload(productReqDto);
//			System.out.println(productCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "업로드 실패",productCode));

		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "업로드 성공", productCode));
	}
	
	@PostMapping("/file/upload")
	public ResponseEntity<?> ProductFileUpload(@RequestBody List<ProductFileReqDto> productFileReqDtos) {
//		System.out.println(productFileReqDtos);
		int productCode = 0;
		boolean productFileUpload = false;
		
		try {
			productFileUpload = productService.productFileUpload(productFileReqDtos);
//			System.out.println(productFileUpload);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "업로드 실패",productFileUpload));

		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "업로드 성공", productFileUpload));
	}
	
	@GetMapping("/matching/{user_code}")
	public ResponseEntity<?> MatchingMyProduct(@PathVariable("user_code") int userCode) {
		
		List<MatchingMyProductListRespDto> result = new ArrayList<>();
		
		try {
			result = productService.findMyProductListByUserCode(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "나의 기자재 불러오기 실패", result));

		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "나의 기자재 불러오기 성공", result));

	}
	
	@GetMapping("/matching/{user_code}/{product_code}")
	public ResponseEntity<?> MatchingMyProductPlus(@PathVariable("user_code") int userCode, @PathVariable("product_code") int productCode) {
		
		List<MatchingMyProductPlusListRespDto> result = new ArrayList<>();
		
		try {
			result = productService.findMyProductPlusListByUserCode(userCode, productCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "나의 기자재 불러오기 실패", result));

		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "나의 기자재 불러오기 성공", result));

	}
}
