package kr.or.nextit.file.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.com.utils.ComAbstractSupport;
import kr.or.nextit.file.service.AttachService;

@Controller
@RequestMapping(value = { "/attach" })
public class AttachController extends ComAbstractSupport {

	@Autowired
	private AttachService attachService;

	// url : /attach/uploadForm.do
	@RequestMapping(value = "/uploadForm.do")
	public String attachUploadForm() {

		return "attach/uploadForm";
	}

	// /attach//uploadProc.do
	@RequestMapping(value = { "/uploadProc.do", "/fileUploadProc.do" })
	public String attachUploadProc(@RequestParam HashMap<String, Object> params,
			@RequestParam("attachFiles") List<MultipartFile> attachFiles, HttpServletRequest request) throws Exception {

		log.debug("params : {}", params);
		log.debug("attachFiles : {}", attachFiles);

		log.debug("업로드 갯수 : {}", attachFiles.size());

		String userIp = request.getRemoteAddr();
		String serviceType = (String) params.get("serviceType");
		attachService.insertFiles(attachFiles, userIp, serviceType);

		for (MultipartFile multipartFile : attachFiles) {
			log.debug(" getName : {} ", multipartFile.getName());
			log.debug(" getContentType : {} ", multipartFile.getContentType());
			log.debug(" getOriginalFilename : {} ", multipartFile.getOriginalFilename());
			log.debug(" getSize : {} ", multipartFile.getSize());
			log.debug(" getInputStream : {} ", multipartFile.getInputStream());
			// log.debug(" getBytes : {} ",
			// multipartFile.getBytes());

			// StringBuilder saveFile = new StringBuilder();
			// saveFile.append(propertyService.getProperty("saveRootPath"));
			// // 윈도우 \ 폴더 구분자를 추가
			// // 리눅스, 유닉스면 /
			// saveFile.append(File.separator);
			// saveFile.append(multipartFile.getOriginalFilename());
			//
			// log.debug("생성 경로 + 파일명 : {}", saveFile.toString());
			// // 파일을 저장할 경로
			// File fileSave = new File(saveFile.toString());
			//
			// // 파일 생성 requeest 객체에서 Multipartfile 정보를
			// // 물리 경로에 생성 함.
			// FileUtils.copyInputStreamToFile(
			// multipartFile.getInputStream(), fileSave);

		}

		return "attach/uploadProc";
	}

	// url : /attach/ajaxSubmitProc.json
	@RequestMapping(value = { "ajaxSubmitProc.json" })
	public @ResponseBody HashMap<String, Object> ajaxSubmitProc(@RequestParam HashMap<String, Object> params,
			@RequestPart("attachFiles") List<Part> attachPart, HttpServletRequest request) {

		HashMap<String, Object> result = new HashMap<>();

		try {

			String userIp = request.getRemoteAddr();
			String serviceType = (String) params.get("serviceType");
			attachService.insertPartFiles(attachPart, userIp, serviceType);

			for (Part part : attachPart) {
				log.debug("getName : {}", part.getName());
				log.debug("getContentType : {}", part.getContentType());
				log.debug("getSubmittedFileName : {}", part.getSubmittedFileName());
				log.debug("getSize : {}", part.getSize());
				log.debug("getInputStream : {}", part.getInputStream());

			}
			// 성공 시
			result.put("message", "정상처리");
			result.put("state", true);

			return result;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			// 에러 발생 시
			result.put("state", false);
			result.put("message", messageSource.getMessage("fail.common.msg", null, Locale.getDefault()));

			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.put("state", false);
			result.put("message", e.getMessage());

			return result;
		}

	}

}
