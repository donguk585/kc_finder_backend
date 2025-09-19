package com.kcFinder.dev.service.notice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kcFinder.dev.domain.notice.NoticeRepository;
import com.kcFinder.dev.web.dto.notice.NoticeDto;
import com.kcFinder.dev.web.dto.notice.NoticeListRespDto;
import com.kcFinder.dev.web.dto.notice.PaginationDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private static final int PAGE_SIZE = 10; // 고정 사이즈

    @Override
    public NoticeListRespDto getNoticeList(int page) throws Exception {
        try {
            // 페이지 번호는 1부터 시작하므로 0-based로 변환
            int offset = (page - 1) * PAGE_SIZE;
            
            // 전체 공지사항 수 조회
            int totalCount = noticeRepository.getTotalNoticeCount();
            int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE);
            boolean hasNext = page < totalPages;
            
            // 공지사항 목록 조회
            List<NoticeDto> notices = noticeRepository.getNoticeList(offset, PAGE_SIZE);
            System.out.println(notices);
            // 페이지네이션 정보 생성
            PaginationDto pagination = PaginationDto.builder()
                    .currentPage(page)
                    .totalPage(totalPages)
                    .size(PAGE_SIZE)
                    .hasNext(hasNext)
                    .build();
            
            return NoticeListRespDto.builder()
                    .items(notices)
                    .pagination(pagination)
                    .build();
                    
        } catch (Exception e) {
            log.error("Error in getNoticeList service for page: {}", page, e);
            throw new RuntimeException("공지사항 목록 조회 중 오류가 발생했습니다.", e);
        }
    }
    
    @Override
    public NoticeDto getNoticeDetail(int noticeId) throws Exception {
        try {
            // 공지사항 상세 조회
        	NoticeDto notice = noticeRepository.getNoticeDetail(noticeId);
            
            if (notice == null) {
                throw new RuntimeException("존재하지 않는 공지사항입니다.");
            }
            
            return notice;
            
        } catch (Exception e) {
            log.error("Error in getNoticeDetail service for noticeId: {}", noticeId, e);
            throw new RuntimeException("공지사항 상세 조회 중 오류가 발생했습니다.", e);
        }
    }
}