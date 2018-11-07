package kr.or.nextit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.nextit.HomeController;

public class InterceptorTest extends HandlerInterceptorAdapter {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, 
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		log.info("postHandle : {}",this.getClass().getCanonicalName());
		log.debug("후처리.postHandle.실행 : {}",this.getClass().getCanonicalName());
	//후 처리
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {
		log.info("preHandle : {}",this.getClass().getCanonicalName());
		log.debug("전처리.preHandle.실행 : {}",this.getClass().getCanonicalName());
	//전 처리
		return true;		//정상 진행
		//return false;		//진행을 멈춤
	}
}
