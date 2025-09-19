package com.kcFinder.dev.web.dto.notice;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDto {
    private Integer notice_id;
    private String title;
    private String contents;
    private LocalDateTime create_date;
}