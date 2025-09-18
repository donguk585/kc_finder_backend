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
public class ProductDetailDto {
    private Integer userCode;
    private Integer productCode;
    private String productName;
    private List<String> productImgPath;
    private String createDate;
    private Integer matchingProductCode;
    private String kcCertificationNum;
    private String matchingProductLink;
    private List<String> matchingKcImgUrl;
}