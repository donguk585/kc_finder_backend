package com.kcFinder.dev.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProductFile {

	private int product_img_code;
	private int product_code;
	private String product_img_path;
}
