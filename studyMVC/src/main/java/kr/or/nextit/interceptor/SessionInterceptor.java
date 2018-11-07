package kr.or.nextit.interceptor;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.nextit.session.service.LoginVo;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {
		
		log.debug("인터셉터 : {}",this.getClass().getCanonicalName());
		
		LoginVo loginInfo=(LoginVo)request.getSession().getAttribute("loginInfo");
		
		if(loginInfo != null) {
			log.debug("loginInfo : {}",loginInfo);
		}else {
			log.error("로그인을 하셔야 사용 할 수 있습니다.");
			ModelAndView modelAndView=new ModelAndView();
			
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/session/actionLoginForm.do");
			modelAndView.setView(redirectView);
			
			//modelAndView.setViewName("redirect:/session/actionLoginForm.do");
			
			//ModelAndViewDefiningException 에러를 발생 한 후 modelAndVew 정로 갱신시킴
			throw new ModelAndViewDefiningException(modelAndView);
		}
		
		return true;
	}
}
