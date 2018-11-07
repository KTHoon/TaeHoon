package kr.or.nextit.file.service.impl;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.file.service.AttachVo;


@Mapper
public interface AttachMapper {

	
	/**
	 * 일반 공통 파일 첨부파일 등록
	 * @param attachVo
	 * @throws Exception
	 */
	public void insertFileItem(
			AttachVo attachVo
			) throws Exception;
	
	/**
	 * 회원 가입시 첨부파일 등록
	 * @param attachVo
	 * @throws Exception
	 */
	public void insertFileProFile(AttachVo attachVo) throws Exception;
	
	/**
	 * seqNo 값으로 첨부파일 1건을 가지고오는  interface
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public AttachVo selectFile(String seqNo)throws Exception;
	
	public void updateFile(int seqNo) throws Exception;
}
