package kr.or.nextit.com.cmm.service.impl;

import org.springframework.stereotype.Service;

import kr.or.nextit.com.cmm.service.TestService;

@Service("TestService")
public class TestServiceImpl implements TestService {

	@Override
	public String getTitle(String title) throws Exception {

		return String.format(" 요청하신 제목 = %s", title);
	}


}
