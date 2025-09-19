package com.kcFinder.dev.web.dto.notice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeListRespDto {
    private List<NoticeDto> items;
    private PaginationDto pagination;
}