package kr.or.nextit.member.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	@Resource(name = "MemberService")
	private MemberService memberService;

	@RequestMapping(value = "/memberInsert.do")
	public ModelAndView memberInsertForm() {

		ModelAndView modelAndView = new ModelAndView("member/memberInsert");

		modelAndView.setViewName("member/memberInsert");
		return modelAndView;
	}
//-----------------------------------------------------------------------------------------------
	@RequestMapping(value = { "/memberinsertProc.do" })
	public String memberInsertProc(
			@ModelAttribute("memberItem") MemberVo memberVo,
			@RequestParam HashMap<String, Object> params,
			@RequestPart Part attachFiles,
			HttpServletRequest request
		) throws Exception {
		log.debug("memberVo : {}", memberVo,attachFiles);
		
		
			log.debug("getName : {}", attachFiles.getName());
			log.debug("getContentType : {}", attachFiles.getContentType());
			log.debug("getSubmittedFileName : {}", attachFiles.getSubmittedFileName());
			log.debug("getSize : {}", attachFiles.getSize());
			log.debug("getInputStream : {}", attachFiles.getInputStream());

		
		//return "member/memberInsert";
		try {
			boolean result = false;
			String memIdCheck = (String) params.get("memIdCheck");
			
			if (memIdCheck.equals(memberVo.getMemId())) {
				String userIp=request.getRemoteAddr();
				result = memberService.insertMemberItem(memberVo,attachFiles,userIp);
			} else {
				throw new NullPointerException("인증 오류");
			}

			if (result) {
				//return "redirect:/member/memberList.do";
				return "redirect:/member/memberView.do?memId="+ memberVo.getMemId();
			} else {
				throw new SQLException("누락된 데이터가 있습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ID 중복체크 하셨나용? {}", e.getMessage());
			return "member/memberInsert";
		}

	}
	

	// /member/memberList.do
	@RequestMapping(value = "/memberList.do")
	public String getMemberList(
			Model model, 
			ModelMap modelMap, 
			@RequestParam HashMap<String, Object> params,
			@ModelAttribute MemberSearchVo memberSearchVo
			
		) throws Exception {

		// List<HashMap<String, Object>> memberList =
		// memberService.getMemberListMap();
		//
		// model.addAttribute("memberList", memberList);

		
		log.debug("params : {}", params);
		log.debug("params : {}", params);
		log.debug("params : {}", params);

		log.debug("memberSearchVo : {} ", memberSearchVo);
		log.debug("memberSearchVo : {} ", memberSearchVo);
		log.debug("memberSearchVo : {} ", memberSearchVo);

		
		int totalCount = memberService.getMemberTotalCnt(memberSearchVo);

		memberSearchVo.setTotalCount(totalCount);
		memberSearchVo.setPageBlockSize(5);
		memberSearchVo.setScreenSize(5);
		memberSearchVo.pageSetting();
		
		log.debug("pagingVo : {}", memberSearchVo);
		log.debug("pagingVo : {}", memberSearchVo);
		log.debug("pagingVo : {}", memberSearchVo);
		log.debug("pagingVo : {}", memberSearchVo);
		log.debug("pagingVo : {}", memberSearchVo);
		
		
		log.debug("검색 결과 조회수 : {} ", totalCount);

		List<MemberVo> memberList = memberService.getMemberListVo(memberSearchVo);

		model.addAttribute("memberList", memberList);

		return "member/memberList";
	}

	@RequestMapping(value = { "/memberView.do" })
	public ModelAndView getMemberItemView(
			ModelAndView modelAndView, 
			@RequestParam HashMap<String, Object> params,
			@ModelAttribute("searchVo") MemberSearchVo memberSearchVo) {

		log.debug("params : {} ", params);
		log.debug("memberSearchVo : {}", memberSearchVo);

		try {
			MemberVo memberItemResult = memberService.selectMemberItem(memberSearchVo);

			modelAndView.addObject("memberItem", memberItemResult);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		modelAndView.setViewName("member/memberView");

		return modelAndView;
	}

	/**
	 * memId (Pk) 삭제를 한후에~~ 리스트로 이동~~~
	 * 
	 * @param modelAndView
	 * @param memberSearchVo
	 * @return
	 */
	@RequestMapping(value = "/memberDelete.do")
	public ModelAndView deleteMemberItem(
			ModelAndView modelAndView, 
			MemberSearchVo memberSearchVo
		) throws Exception {

		boolean result = memberService.deleteMemberItem(memberSearchVo.getMemId());

		RedirectView redirectView = new RedirectView();

		if (result) {
			// 성공 적으로 삭제 완료
			redirectView.setUrl("/member/memberList.do");
		} else {
			// 삭제시 에러
			redirectView.setUrl("/member/memberView.do");
			redirectView.addStaticAttribute("memId", memberSearchVo.getMemId());
		}

		modelAndView.setView(redirectView);

		return modelAndView;
	}

	@RequestMapping(value = "/memberUpdate.do")
	public String updateMemberForm(
			ModelMap modelMap, 
			@RequestParam HashMap<String, Object> params,
			@ModelAttribute MemberSearchVo memberSearchVo
		) throws Exception {

		log.debug("params : {}", params);
		log.debug("memberSearchVo : {}", memberSearchVo);

		MemberVo memberItem = memberService.selectMemberItem(memberSearchVo);

		modelMap.addAttribute("memberItem", memberItem);

		return "member/memberUpdate";
	}

	@RequestMapping(value = { "/memberUpdateProc.do" })
	public String updateMemberProc(
			@ModelAttribute MemberVo memberVo, 
			@RequestParam HashMap<String, Object> params
			) throws Exception {

		log.debug("memberVo : {}", memberVo);
		log.debug("params : {}", params);

		try {

			boolean result = memberService.updateMemberItem(params);

			if (result) {

				return "redirect:/member/memberView.do?memId=" + memberVo.getMemId();

			} else {
				throw new SQLException("질의어수행시 에러가 발생하였습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(), e);
		}

	}

}
