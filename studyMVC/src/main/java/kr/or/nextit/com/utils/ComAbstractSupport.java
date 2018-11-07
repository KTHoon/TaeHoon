package kr.or.nextit.com.utils;

import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

public abstract class  ComAbstractSupport {
	
	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "propertyService")
	public Properties propertyService;

	@Resource(name = "messageSource")
	public MessageSource messageSource;
	
}
