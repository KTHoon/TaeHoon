package kr.or.nextit.member.service.impl;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

@Mapper
public interface MemberMapper {
	
	/**
	 * memId 값을 가지고 중복 체크 하는 기능 ..
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberIdCheck(
			HashMap<String, Object> params
			) throws Exception;
		
	

	/**
	 * 데이터 레이어 단 회원 가입
	 * @param memberVo
	 * @throws Exception
	 */
	public void insertMemberItem( 
			MemberVo memberVo
		) throws Exception;
	
	
	
	/**
	 * 회원 리스트 반환
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(
			MemberSearchVo memberSearchVo
			) throws Exception;
	
	
	/**
	 * 검색 결과에 대한 전체 갯수 반환
	 * @return
	 * @throws Exception
	 */
	public int selectMemberCnt(
			MemberSearchVo memberSearchVo
			) throws Exception;
	
	
	
	/**
	 * pk 값인 memId 값을 받아서 조회 하는 기능..
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberItem(
			MemberSearchVo params
			) throws Exception;
	
	
	
	/**
	 * 데이터 레이어 계층에서 memId (PK) 레코드 삭제하는 기능
	 * @param memId
	 * @throws Exception
	 */
	public void deleteMemberItem(
			String memId
			) throws Exception;
	
	
	
	/**
	 * 회원정보를 수정하는 데이터 레이어단..
	 * @param params
	 * @throws Exception
	 */
	public void updateMemberItem(
			HashMap<String, Object> params
			) throws Exception;
	
	
	
	
	
	
	
	
	
	
}
