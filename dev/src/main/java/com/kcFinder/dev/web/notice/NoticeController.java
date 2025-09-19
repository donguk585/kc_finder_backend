package com.kcFinder.dev.web.notice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcFinder.dev.service.notice.NoticeService;
import com.kcFinder.dev.web.dto.CMRespDto;
import com.kcFinder.dev.web.dto.notice.NoticeDto;
import com.kcFinder.dev.web.dto.notice.NoticeListRespDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/notice")
@RequiredArgsConstructor
@Slf4j
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/list/{page}")
    public ResponseEntity<?> getNoticeList(@PathVariable("page") int page) {
        try {
            NoticeListRespDto result = noticeService.getNoticeList(page);
            return ResponseEntity.ok().body(new CMRespDto<>(1, "공지사항 목록 조회 성공", result));
        } catch (Exception e) {
            log.error("Error getting notice list for page: {}", page, e);
            return ResponseEntity.ok().body(new CMRespDto<>(0, "공지사항 목록 조회 실패", null));
        }
    }
    
    @GetMapping("/detail/{noticeId}")
    public ResponseEntity<?> getNoticeDetail(@PathVariable("noticeId") int noticeId) {
        try {
        	NoticeDto result = noticeService.getNoticeDetail(noticeId);
            return ResponseEntity.ok().body(new CMRespDto<>(1, "공지사항 상세 조회 성공", result));
        } catch (Exception e) {
            log.error("Error getting notice detail for noticeId: {}", noticeId, e);
            return ResponseEntity.ok().body(new CMRespDto<>(0, "공지사항 상세 조회 실패", null));
        }
    }
}