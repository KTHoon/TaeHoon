package kr.or.nextit.file.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.com.utils.ComAbstractSupport;
import kr.or.nextit.file.service.AttachService;
import kr.or.nextit.file.service.AttachVo;

@Controller
public class DownloadController extends ComAbstractSupport {
	@Resource(name="AttachService")
	private AttachService attach;
	
	@RequestMapping(value="/attach/downloadTest.do")
	public String downloadTest() {
		
		return "attach/downloadTest";
	}
	@RequestMapping(value = "/attach/download/{seqNo}")
	public void downloadFile(@RequestParam HashMap<String, Object> params, 
							 @PathVariable("seqNo") String seqNo,
							 HttpServletRequest request, 
							 HttpServletResponse response) throws Exception {
		
		AttachVo fileItem=attach.selectFile(seqNo);
		
		StringBuilder filePath=new StringBuilder();
		
		filePath.append(propertyService.getProperty("saveRootPath"));
		filePath.append(fileItem.getSavePath());
		filePath.append(fileItem.getSaveName());
		
		byte fileByte[] =FileUtils.readFileToByteArray(new File(filePath.toString()));
		log.debug("file Name : {}",fileItem.getFileName());
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content_Disposition","attachment; fileName=\""+URLEncoder.encode(fileItem.getFileName(),"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding","binary");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		log.debug("filePath : {}",filePath);
		log.debug("fileItem : {}",fileItem);
		log.debug("params: {}", params);
		log.debug("fileId: {}", seqNo);
		
	}
}

