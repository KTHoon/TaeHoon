package kr.or.nextit.file.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.com.utils.ComAbstractSupport;
import kr.or.nextit.file.service.AttachService;
import kr.or.nextit.file.service.AttachVo;

@Service("AttachService")
public class AttachServiceImpl extends ComAbstractSupport implements AttachService {

	@Autowired
	private AttachMapper attachMapper;

	@Override
	public List<AttachVo> insertFiles(List<MultipartFile> attachFiles, String userIp, String serviceType)
			throws Exception {

		List<AttachVo> fileResult = new ArrayList<>();

		String refSeqNo = UUID.randomUUID().toString();

		for (MultipartFile multipartFile : attachFiles) {

			if (multipartFile.getOriginalFilename() != null && !multipartFile.getOriginalFilename().equals("")) {

				AttachVo fileItem = new AttachVo();

				fileItem.setRefSeqNo(refSeqNo);
				fileItem.setFileName(multipartFile.getOriginalFilename());

				fileItem.setSaveName(UUID.randomUUID().toString());

				String savePath = String.format("%s%s%s", File.separator, serviceType, File.separator);
				fileItem.setSavePath(savePath);

				fileItem.setSaveSize(multipartFile.getSize());
				fileItem.setSaveContentType(multipartFile.getContentType());

				fileItem.setUsrIp(userIp);
				fileItem.setServiceType(serviceType);

				attachMapper.insertFileItem(fileItem);

				fileResult.add(fileItem);

				StringBuilder saveFile = new StringBuilder();
				saveFile.append(propertyService.getProperty("saveRootPath"));
				saveFile.append(fileItem.getSavePath());
				saveFile.append(fileItem.getSaveName());

				File fileSave = new File(saveFile.toString());
				FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), fileSave);

			} // if end

		} // for end

		return fileResult;
	}

	@Override
	public List<AttachVo> insertPartFiles(List<Part> attachFiles, String userIp, String serviceType) throws Exception {

		List<AttachVo> fileResult = new ArrayList<>();

		String refSeqNo = UUID.randomUUID().toString();

		for (Part part : attachFiles) {

			if (part.getSubmittedFileName() != null && part.getSubmittedFileName().equals("")) {

				AttachVo fileItem = new AttachVo();
				fileItem.setRefSeqNo(refSeqNo);
				fileItem.setSaveName(UUID.randomUUID().toString());

				String savePath = String.format("%s%s%s", File.separator, serviceType, File.separator);
				fileItem.setSavePath(savePath);

				fileItem.setSaveSize(part.getSize());
				fileItem.setSaveContentType(part.getContentType());

				fileItem.setUsrIp(userIp);
				fileItem.setServiceType(serviceType);

				attachMapper.insertFileItem(fileItem);

				fileResult.add(fileItem);

				StringBuilder saveFile = new StringBuilder();
				saveFile.append(propertyService.getProperty("saveRootPath"));
				saveFile.append(fileItem.getSavePath());
				saveFile.append(fileItem.getSaveName());

				File fileSave = new File(saveFile.toString());
				FileUtils.copyInputStreamToFile(part.getInputStream(), fileSave);

			}
		}
		return null;
	}

	@Override
	public AttachVo selectFile(String seqNo) throws Exception {
		
		return attachMapper.selectFile(seqNo);
	}

	@Override
	public void updateFile(int seqNo) throws Exception {
		attachMapper.updateFile(seqNo);
	}

}
