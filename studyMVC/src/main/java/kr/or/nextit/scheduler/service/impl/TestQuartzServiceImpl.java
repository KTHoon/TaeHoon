package kr.or.nextit.scheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.com.utils.ComAbstractSupport;
import kr.or.nextit.file.service.AttachService;
import kr.or.nextit.scheduler.service.TestQuartzService;

@Service("TestQuartzService")
public class TestQuartzServiceImpl  extends ComAbstractSupport implements TestQuartzService {
	
	@Autowired
	private AttachService attachService;
	
	
	@Override
	public void getTest() throws Exception {
		log.debug("스케줄러 : {}",this.getClass().getCanonicalName());
		
		
		for(int i=0; i<=50; i++) {
			attachService.updateFile(i);
		}
	}

	@Override
	public void getTitle() throws Exception {
		log.debug("2번째 스케줄러 : {} ",this.getClass().getCanonicalName());
		
	}

}
