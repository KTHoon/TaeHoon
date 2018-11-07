package kr.or.nextit.com.cmm.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.com.cmm.service.ComCodeService;
import kr.or.nextit.com.cmm.service.CommCodeVo;
import kr.or.nextit.common.error.BizException;



/**
 * 비지니스 레이어 영역으로 데이터 베이스 연결 객체를 생성을 하고, 요청된 param 값을 가지고 제어 해주는 비지니스 플로우...
 * 
 * @author ssam
 *
 */
@Service("ComCodeService")
public class ComCodeServiceImpl implements ComCodeService {

	// mybatis 전용
	@Autowired
	private ComMapper comMapper;

	@Override
	public List<CommCodeVo> getCodeList(String groupId) {

		return null;
	}

	@Override
	public CommCodeVo getCodeName(String clientIp) {
		return null;
	
	}

	@Override
	public void getErrorTest(String testValue) throws Exception {

		
	}

	@Override
	public void getErrorTest2(String testValue) throws Exception {

		
	}

	@Override
	public void getBizErrorTest(String testValue) throws BizException {

		
	}

	@Override
	public void getBizErrorTest2(String testValue) throws Exception {

		
	}

	@Override
	public List<CommCodeVo> getIpList() throws Exception {

		return comMapper.getIpList(null);
	}

	@Override
	public CommCodeVo getIpItem(String clientIp) throws Exception {

		CommCodeVo commCodeVo=new CommCodeVo();
		commCodeVo.setKey(clientIp);
		
		return comMapper.getIpItem(commCodeVo);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kr.or.nextit.function.service.ComCodeService#getCodeList(java.lang.String)
	 */
	
}
