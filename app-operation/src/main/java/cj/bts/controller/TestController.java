package cj.bts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cj.bts.config.Operation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/bts")
@RestController
public class TestController {
	@GetMapping("/test")
	public String test(Operation operation) {
		return "OK==> " + operation.getId() + ":" + operation.getEmpNo();
	}
}
