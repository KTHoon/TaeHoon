package kr.or.nextit.member.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Part;

public interface MemberService {

	/**
	 * 아이디 중복 체크 기능.
	 * @param memberVo
	 * @return
	 * @throws Exception
	 */
	public boolean selectMemberIdCheck(
			MemberVo memberVo
		) throws Exception;
	
	
	
	/**
	 * 회원 가입
	 * @param memberVo
	 * @return
	 * @throws Exception
	 */
	public boolean insertMemberItem(
			MemberVo memberVo,
			Part attachItem,
			String userIp
			) throws Exception;
	
	
	
	/**
	 * test 서비스 메소드
	 * @return List<HashMap<String, Object>>  
	 * @throws Exception
	 */
	public List<HashMap<String, Object>> getMemberListMap(
			) throws Exception;
	
	
	/**
	 * Vo 객체로 반환 회원 리스트
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> getMemberListVo(
			MemberSearchVo memberSearchVo
			) throws Exception;
	
	
	/**
	 * 검색 을 기준으로 조회된 토탈 카운터를 구하는 메소드..
	 * @param memberSearchVo
	 * @return
	 * @throws Exception
	 */
	public int getMemberTotalCnt(
			MemberSearchVo memberSearchVo
			)throws Exception;
	
	
	/**
	 * memId 정보를 받아서 해당하는 정보를 가지고 오는 기능 (1건 db pk)
	 * @param memberSearchVo
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberItem(
			MemberSearchVo memberSearchVo
			) throws Exception;
	
	
	
	/**
	 * memId 값을 문자열로 받아서 삭제하는 기능.
	 * @param memId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteMemberItem(
			String memId
			) throws Exception;
	
	
	
	/**
	 * HashMpa 값을 데이터베이스에서  pk 조건으로 수정 하는 기능.
	 * @return
	 * @throws Exception
	 */
	public boolean updateMemberItem(
			HashMap<String, Object> params
			) throws Exception;
	
	
	
	
}
