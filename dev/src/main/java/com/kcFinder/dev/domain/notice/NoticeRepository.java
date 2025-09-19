package com.kcFinder.dev.domain.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kcFinder.dev.web.dto.notice.NoticeDto;

@Repository
@Mapper
public interface NoticeRepository {
    public List<NoticeDto> getNoticeList(@Param("offset") int offset, @Param("size") int size) throws Exception;
    
    public int getTotalNoticeCount() throws Exception;
    
    public NoticeDto getNoticeDetail(@Param("noticeId") int noticeId) throws Exception;
}