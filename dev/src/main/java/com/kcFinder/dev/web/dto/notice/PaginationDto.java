package com.kcFinder.dev.web.dto.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDto {
    private int currentPage;
    private int totalPage;
    private int size;
    private boolean hasNext;
}