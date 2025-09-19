package com.kcFinder.dev.service.notice;

import com.kcFinder.dev.web.dto.notice.NoticeDto;
import com.kcFinder.dev.web.dto.notice.NoticeListRespDto;

public interface NoticeService {
	public NoticeListRespDto getNoticeList(int page) throws Exception;
	
	public NoticeDto getNoticeDetail(int noticeId) throws Exception;
}
