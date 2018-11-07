package kr.or.nextit.source.message.web;

import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageSourceController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "propertyService")
	private Properties propertyService;

	@Resource(name = "messageSource")
	private MessageSource messageSource;
	
	
	
	

	@RequestMapping(value = "/messagesource.do")
	public String getMessageSourceTest() {

		String msg = messageSource.getMessage("fail.common.msg", null, Locale.getDefault());
		log.debug("key : fail.common.msg, value : {}", msg);

		Object[] args = { "0000", "오타입니다..." };
		String sql = messageSource.getMessage("fail.common.sql", args, Locale.ENGLISH);
		log.debug(" {}", sql);
		log.debug(" {}", sql);

		System.out.println("==================================================");

		log.debug("ENGLISH : {}", messageSource.getMessage("fail.common.sql", args, Locale.ENGLISH));
		log.debug("KOREA : {}", messageSource.getMessage("fail.common.sql", args, Locale.KOREA));
		log.debug("ENGLISH : {}", messageSource.getMessage("fail.common.sql", args, Locale.ENGLISH));
		log.debug("KOREA : {}", messageSource.getMessage("fail.common.sql", args, Locale.KOREA));

		return "properties/messageSource";
	}

	@RequestMapping(value = "/propertyService.do")
	public String getPropertyServiceTest(Model model, ModelMap modelMap) {

		log.debug("driver : {} ", propertyService.getProperty("driver"));
		log.debug("url : {} ", propertyService.getProperty("url"));
		log.debug("username : {} ", propertyService.getProperty("username"));
		log.debug("password : {} ", propertyService.getProperty("password"));

		log.debug("admin : {} ", propertyService.getProperty("admin"));

		log.debug("fail.common.sql : {} ", propertyService.getProperty("fail.common.sql"));

		log.debug("saveRootPath : {} ", propertyService.getProperty("saveRootPath"));

		model.addAttribute("saveRootPath", propertyService.getProperty("saveRootPath"));

		modelMap.addAttribute("saveRootPath2", propertyService.getProperty("saveRootPath"));

		return "properties/messageSource";
	}

}
