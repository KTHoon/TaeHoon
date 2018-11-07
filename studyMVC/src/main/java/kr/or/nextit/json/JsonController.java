package kr.or.nextit.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Controller
public class JsonController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "/json", "/jsonTest" })
	public String jsonTest() {

		return "json/jsonTest";
	}

	@RequestMapping(value = "/json/responseEntity.json")
	public ResponseEntity<?> getResponseEntity() {

		HashMap<String, Object> result = new HashMap<>();
		result.put("name1", "오하영");
		result.put("name2", "이영애");
		result.put("name3", "말자");
		result.put("name4", "말자");
		result.put("name5", "말자");

		return new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);

	}

	@RequestMapping(value = "/json/responseEntity2.json")
	public ResponseEntity<?> getResponseEntity2() {

		List<HashMap<String, Object>> arrayResult = new ArrayList<>();

		HashMap<String, Object> result = new HashMap<>();
		result.put("name1", "오하영");
		result.put("name2", "이영애");
		result.put("name3", "말자");

		arrayResult.add(result);
		
		
		result = new HashMap<>();
		result.put("name1", "홍길동");
		result.put("name2", "장동건");
		result.put("name3", "영수");
		
		arrayResult.add(result);

		return new ResponseEntity<List<HashMap<String, Object>>>(arrayResult, HttpStatus.OK);

	}

	@RequestMapping(value = "/json/responseEntity3.json")
	public ResponseEntity<?> getResponseEntity3() {

		HashMap<String, Object> result = new HashMap<>();
		result.put("name", "오하영");
		result.put("name2", "이영애");
		result.put("name3", "말자");

		List<String> listResult = new ArrayList<>();
		listResult.add("1시");
		listResult.add("2시");
		listResult.add("3시");
		listResult.add("4시");
		listResult.add("5시");

		result.put("time", listResult);

		MemberVo memberVo = new MemberVo();
		memberVo.setMemId("master");
		memberVo.setMemName("오하영");

		result.put("member", memberVo);

		return new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);

	}

	@RequestMapping(value = "/json/responseEntity4.json")
	public ResponseEntity<?> getResponseEntity4() throws Exception {

		HashMap<String, Object> result = new HashMap<>();

		try {
			MemberSearchVo memberSearchVo = new MemberSearchVo();

			List<MemberVo> memberList = memberService.getMemberListVo(memberSearchVo);

			result.put("memberList", memberList);
			result.put("message", "조회 완료 ~~");
			result.put("state", true);

		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", e.getMessage());
			result.put("state", false);
			// throw new Exception(e.getMessage());
		}

		return new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);

	}

	@RequestMapping(value = "/json/responseBody.json")
	public @ResponseBody HashMap<String, Object> getResponseBody() {

		HashMap<String, Object> result = new HashMap<>();
		result.put("name", "오하영");
		result.put("name2", "이영애");
		result.put("name3", "말자");

		return result;

	}

	@RequestMapping(value = "/json/responseBody2.json")
	public @ResponseBody List<HashMap<String, Object>> getResponseBody2(@RequestParam HashMap<String, Object> params) {

		List<HashMap<String, Object>> arrayResult = new ArrayList<>();

		HashMap<String, Object> result = new HashMap<>();
		result.put("name", "오하영");
		result.put("name2", "이영애");
		result.put("name3", "말자");

		arrayResult.add(result);

		return arrayResult;

	}

	@RequestMapping(value = "/json/responseBody3.json")
	public @ResponseBody HashMap<String, Object> getResponseBody3(@RequestParam HashMap<String, Object> params)
			throws Exception {

		HashMap<String, Object> result = new HashMap<>();

		try {
			MemberSearchVo memberSearchVo = new MemberSearchVo();
			result.put("memberList", memberService.getMemberListVo(memberSearchVo));
			result.put("message", "조회 완료 ~~");
			result.put("state", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", e.getMessage());
			result.put("state", false);
		}
		return result;
	}

}
