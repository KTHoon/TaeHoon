package kr.or.nextit.member.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.com.utils.ComAbstractSupport;
import kr.or.nextit.file.service.AttachVo;
import kr.or.nextit.file.service.impl.AttachMapper;
import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Service("MemberService")
public class MemberServiceImpl extends ComAbstractSupport implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private AttachMapper attachMapper;
	
	@Override
	public List<HashMap<String, Object>> getMemberListMap(
			) throws Exception {

		List<HashMap<String, Object>> memberList = new ArrayList<>();
		
		HashMap<String, Object> memberItem = new HashMap<>();
		memberItem.put("memId", "master");
		memberItem.put("memName", "홍길동");
		memberList.add(memberItem);
		
		memberItem = new HashMap<>();
		memberItem.put("memId", "admin");
		memberItem.put("memName", "오하영");
		memberList.add(memberItem);
		
		return memberList;
	}

	@Override
	public List<MemberVo> getMemberListVo(
			MemberSearchVo memberSearchVo
			) throws Exception {

		return memberMapper.selectMemberList(memberSearchVo);
	}

	@Override
	public int getMemberTotalCnt(
			MemberSearchVo memberSearchVo
		) throws Exception {
		return memberMapper.selectMemberCnt(memberSearchVo);
	}

	@Override
	public MemberVo selectMemberItem(MemberSearchVo memberSearchVo) throws Exception {

		return memberMapper.selectMemberItem(memberSearchVo);
	}

	@Override
	public boolean deleteMemberItem(String memId) throws Exception {
 
		
		try {
			memberMapper.deleteMemberItem(memId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateMemberItem(HashMap<String, Object> params) throws Exception {

		try {
			memberMapper.updateMemberItem(params);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean insertMemberItem(MemberVo memberVo,Part attachItem,String userIp) throws Exception {
 
		String serviceType="profile";
		
		try {
			
			memberMapper.insertMemberItem(memberVo);
			if (attachItem.getSubmittedFileName() != null && !attachItem.getSubmittedFileName().equals("")) {

				AttachVo fileItem = new AttachVo();

				fileItem.setRefSeqNo("profile");
				fileItem.setUserId(memberVo.getMemId());
				fileItem.setFileName(attachItem.getSubmittedFileName());

				fileItem.setSaveName(UUID.randomUUID().toString());

				String savePath = String.format("%s%s%s", File.separator, serviceType, File.separator);
				fileItem.setSavePath(savePath);

				fileItem.setSaveSize(attachItem.getSize());
				fileItem.setSaveContentType(attachItem.getContentType());

				fileItem.setUsrIp(userIp);
				fileItem.setServiceType(serviceType);

				attachMapper.insertFileProFile(fileItem);


				StringBuilder saveFile = new StringBuilder();
				saveFile.append(propertyService.getProperty("saveRootPath"));
				saveFile.append(fileItem.getSavePath());
				saveFile.append(fileItem.getSaveName());

				File fileSave = new File(saveFile.toString());
				FileUtils.copyInputStreamToFile(attachItem.getInputStream(), fileSave);

			} // if end
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean selectMemberIdCheck(MemberVo memberVo) throws Exception {
		try {
			HashMap<String, Object> params = new HashMap<>();
			params.put("userCheckId", memberVo.getMemId());
			
			MemberVo memberVoResult = memberMapper.selectMemberIdCheck(params);

			log.debug("memberVo : {}",memberVo);
			log.debug("memberVoResult : {}",memberVoResult);
			
			if (memberVoResult == null && !memberVo.getMemId().equals("")) {
				return true;
			} else {
				return false;
			}
			 
//			if(memberVo.getMemId().equals(memberVoResult.getMemId())) {
//				throw new Exception("중복된 아이디가 있습니다.");
//			} else {
//				throw new NullPointerException("중복된 데이타가 없습니다.");
//			}
	 
		}catch (NullPointerException ex) {
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
