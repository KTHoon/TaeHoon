package kr.or.nextit.member.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;
import oracle.net.aso.p;

@Controller
public class IdCheckController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value= {"/member/idcheck.do"})
	public @ResponseBody HashMap<String, Object> memberIdCheck(
			@RequestParam HashMap<String, Object> params,
			@ModelAttribute MemberVo memberVo
			)  {
		
		log.debug("params : {} ",params );
		log.debug("memberVo : {} ",memberVo );
		HashMap<String, Object> result = new HashMap<>();
		try {
			boolean idCheckResult = memberService.selectMemberIdCheck(memberVo);
			
			result.put("state", idCheckResult);
			
			if (idCheckResult) {
				result.put("message","사용 가능한 아이디 입니다.");
			} else {
				result.put("message","중복된 아이디 입니다.");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("message", ex.getMessage());
			result.put("state", false);
		}
		return result;
		
	}
}
