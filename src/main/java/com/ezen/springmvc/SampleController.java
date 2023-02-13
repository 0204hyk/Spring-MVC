package com.ezen.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Employee;

@Controller
public class SampleController {
	
	private static Logger log = LogManager.getLogger(SampleController.class);
	
	@RequestMapping(value = "/sample", method = {RequestMethod.GET, RequestMethod.POST})
	public String index() {
		// /WEB-INF/views/ 아래의 경로를 리턴해야한다.
		return "sample/index"; 
	}
	
	@GetMapping(value = {"/sample/get"})
	public String get() {
		return "sample/form";
	}
	
	@PostMapping("/sample/post")
	public String post(HttpServletRequest request) {
		System.out.println(request.getParameter("employee_id"));
		System.out.println(request.getParameter("first_name"));
		System.out.println(request.getParameter("last_name"));
		
//		Employee e = new Employee();
//		
//		e.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
//		e.setFirst_name(request.getParameter("first_name"));
//		e.setLast_name(request.getParameter("last_name"));
//		
//		request.setAttribute("employee", e);
		
		return "sample/result";
	}
	
	@PostMapping("/sample/post2")
	public String post2(Employee emp) {
		// request에서 꺼낼 필요 없이 자동으로 담아준다. (단, 모델에 쓴 필드의 이름과, 폼에 쓴 name의 이름이 같아야 한다.)
		log.info(emp);
		
		return "sample/result";
	}
	
	@PostMapping("/sample/post3")
	public String post3(
			@ModelAttribute("employee_id") Integer e_id, 
			@ModelAttribute("first_name") String f_name, 
			@ModelAttribute("last_name") String l_name) {
		
		log.info(e_id);
		log.info(f_name);
		log.info(l_name);
		
		return "sample/result";
	}
	
	@GetMapping("/sample/find/void")
	public void orange(Employee e) {
		log.info(e);
		
	}
}
