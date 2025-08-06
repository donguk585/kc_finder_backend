package com.kcFinder.dev.web.admin.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcFinder.dev.service.admin.product.AdminProductService;
import com.kcFinder.dev.web.dto.CMRespDto;
import com.kcFinder.dev.web.dto.admin.product.AdminUserProductRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/product")
@RequiredArgsConstructor
public class AdminProductController {

	private final AdminProductService adminProductService;
	
	@GetMapping("/matching")
	public ResponseEntity<?> AdminMatchingProduct() {
		
		List<AdminUserProductRespDto> result = new ArrayList<>();
		
		try {
			result = adminProductService.findProductListForAdmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "기자재 불러오기 실패", result));

		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "기자재 불러오기 성공", result));

	}
}
