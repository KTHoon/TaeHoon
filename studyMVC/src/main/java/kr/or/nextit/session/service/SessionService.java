package kr.or.nextit.session.service;

public interface SessionService {
	
	/**
	 * 로그인 체크
	 * @return
	 * @throws Exception
	 */
	public LoginVo selectLoginCheck(LoginVo loginVo)throws Exception;
	
}
