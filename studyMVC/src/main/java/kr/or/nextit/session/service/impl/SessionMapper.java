package kr.or.nextit.session.service.impl;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.session.service.LoginVo;

@Mapper
public interface SessionMapper {
	public LoginVo selectMemberItem(LoginVo loginVo) throws Exception;
}
