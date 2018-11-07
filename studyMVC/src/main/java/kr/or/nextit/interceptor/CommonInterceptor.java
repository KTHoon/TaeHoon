package kr.or.nextit.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.nextit.com.cmm.service.ComCodeService;
import kr.or.nextit.com.cmm.service.CommCodeVo;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ComCodeService comCodeService;
	
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, 
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		
		log.debug("userIp : {}", request.getRemoteAddr());
		
		List<CommCodeVo> ipList = comCodeService.getIpList();
		modelAndView.addObject("ipList",ipList);
		modelAndView.addObject("userIp", request.getRemoteAddr());
		
		modelAndView.addObject("userIp",request.getRemoteAddr());
		
	}
}
