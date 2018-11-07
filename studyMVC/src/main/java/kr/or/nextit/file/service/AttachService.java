package kr.or.nextit.file.service;

import java.util.List;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

public interface AttachService {

	public List<AttachVo> insertFiles(
			List<MultipartFile> attachFiles,
			String userIp,
			String serviceType
			) throws Exception;
	
	/**파일 업로드
	 * @param attachFiles
	 * @param userIp
	 * @param serviceType
	 * @return
	 * @throws Exception
	 */
	public List<AttachVo> insertPartFiles(
			List<Part> attachFiles,
			String userIp,
			String serviceType
			) throws Exception;

	/**
	 * seqNo값으로 데이터 베이스에 저장된 1개의 레코드를 가지고옴
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public AttachVo selectFile(String seqNo)throws Exception;
	
	/**
	 * 전체 업데이트
	 * @throws Exception
	 */
	public void updateFile(int seqNo) throws Exception;


}
