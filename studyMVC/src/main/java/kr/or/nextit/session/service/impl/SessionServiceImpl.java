package kr.or.nextit.session.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.com.utils.ComAbstractSupport;
import kr.or.nextit.session.service.LoginVo;
import kr.or.nextit.session.service.SessionService;

@Service("SessionService")
public class SessionServiceImpl extends ComAbstractSupport implements SessionService {
	
	@Autowired
	private SessionMapper sessionMapper;
	
	@Override
	public LoginVo selectLoginCheck(LoginVo loginVo) throws Exception {
		
		
		return sessionMapper.selectMemberItem(loginVo);
	}

}
