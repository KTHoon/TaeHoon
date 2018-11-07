package kr.or.test.nextit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.nextit.com.cmm.service.TestService;

@Controller
public class TestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	private TestService testService ;
	
	private String name;
	
	private int age;
	
	
	@RequestMapping(value= {"/testForm.do"})
	private String testForm(
				Model model
			) throws Exception {

		log.info("testForm 메소드 실행 .. {} ", this.getClass().getName());
		
		log.debug(" {}", testService.getTitle("test page"));
		
		log.debug(" servlet-context 입력값 : {}",name);
		
		model.addAttribute("tName",name);
		model.addAttribute("tTitle", testService.getTitle("service Data"));
		model.addAttribute("age", age);
		
		
		// path +  jsp 파일 위치
		return "test/TestForm";

	}



	public TestService getTestService() {
		return testService;
	}



	public void setTestService(TestService testService) {
		this.testService = testService;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
}





