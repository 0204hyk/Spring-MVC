package com.ezen.springmvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.model.Book;

@RequestMapping("hello")
@Controller
public class HelloController {

	// Sysout ��� Log4j�� �α� ���
	
	// 1. Logger ����
	
	// Log4j 
	private static Logger log = Logger.getLogger(HelloController.class);
	
	// Log4j2
	private static org.apache.logging.log4j.Logger log2 = 
			org.apache.logging.log4j.LogManager.getLogger(HelloController.class);
	
	Book b1 = new Book();
	@Autowired
	Book b2, b3;
	@Autowired
	Book b4;
	
	@RequestMapping("log")
	String log() {
		// 2. ���ϴ� �α׸� Logger�� �߰��ϱ� (�α� �޼������� ����� ������ �� �ִ�.)
		log.fatal("Fatal level log message.");
		log.error("Error level log message.");
		log.warn("Warn level log message.");     // Root Logger
		log.info("Info level log message.");	 
		log.debug("Debug level log message.");
		log.trace("Trace level log message.");	 
		// src/main/resources/log4j.xml ���� ������
		// Application Logger�� debug�� �����س��� ������ debug �̻� ����� �αװ� �� ���´�. (Root Logger���� �켱)
				
		return "hello/index";
	}
	
	@RequestMapping("log2")
	String log2() {
		log2.fatal("Fatal level log message.");
		log2.error("Error level log message.");
		log2.warn("Warn level log message.");
		log2.info("Info level log message.");	 
		log2.debug("Debug level log message.");
		log2.trace("Trace level log message.");	 

		return "hello/index";
	}
	
	@RequestMapping("index")
	String index() {
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		b2.setAuthor("����.K.�Ѹ�");
		System.out.println(b2.getAuthor());
		System.out.println(b3.getAuthor());
		System.out.println(b4.getAuthor());
		
		// ���� ���� ��ġ�� String Ÿ������ �����Ѵ�.
		// /WEB-INF/views/ + return�� + .jsp
		return "hello/index";
	}
	
	
}
