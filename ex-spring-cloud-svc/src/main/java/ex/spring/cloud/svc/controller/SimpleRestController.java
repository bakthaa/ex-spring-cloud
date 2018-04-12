package ex.spring.cloud.svc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	
	@GetMapping("msg")
	String getClientMsg(@Value("${msg}") String msg) {
		
		return msg;
	}

}
