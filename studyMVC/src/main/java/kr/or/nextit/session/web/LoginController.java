package kr.or.nextit.session.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.or.nextit.com.utils.ComAbstractSupport;
import kr.or.nextit.session.service.LoginVo;
import kr.or.nextit.session.service.SessionService;

@Controller
@RequestMapping(value="session")
public class LoginController extends ComAbstractSupport {
	
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value="/actionLoginForm.do")
	public String actionLoginForm(
				Model model,
				@ModelAttribute("loginVo") LoginVo loginVo) {
		model.addAttribute("loginVo",loginVo);
		return "session/actionLoginForm";
	}
	
	@RequestMapping(value="/actionLoginProc.do")
	public String actionLoginProc(
				Model model,
				@ModelAttribute("loginVo") LoginVo loginVo,
				HttpSession session) throws Exception {
		
		log.debug("param loginVo : {}" , loginVo);
		LoginVo loginInfo = sessionService.selectLoginCheck(loginVo);
		log.debug("return loginInfo : {}" , loginInfo);
		if(loginInfo != null) {
			
			if(loginInfo.getMemId().equals(loginVo.getMemId()) &&
			   loginInfo.getMemPwd().equals(loginVo.getMemPwd())
			) {
				session.setAttribute("loginInfo", loginInfo);
			}
			//modelAndView 객체를 사용할 경우 RedirectView 사용
			//return "redirect:/index.do";
			return "redirect:/";
		}else {
			session.removeAttribute("loginInfo");
			return "session/actionLoginForm";
		}
	}
	@RequestMapping(value="/actionLogOut.do")
	public String actionLogOut(HttpSession session)throws Exception {
		
		//session key(loginInfo) null 초기화
		session.setAttribute("loginInfo", null);
		//session key(loginInfo)  삭제
		session.removeAttribute("loginInfo");
		//모든 세션 객체 삭제
		session.invalidate();
		
		return "redirect:/";
	}
}
