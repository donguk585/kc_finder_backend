package com.kcFinder.dev.web.dto.product;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductListRespDto {
    private List<ProductDetailDto> items;
    private PaginationDto pagination;
}
