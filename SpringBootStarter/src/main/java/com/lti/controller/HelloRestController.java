package com.lti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path="HelloApp")
public class HelloRestController {
	
//	http://localhost:9090/HelloApp/hello
//	method: GET
	@RequestMapping(path = "hello", method = RequestMethod.GET)
	public String hello1() {
		return "Hello from this Side";
	}
//	http://localhost:9090/HelloApp/hello
//	method: POST1
	@RequestMapping(path = "hello", method = RequestMethod.POST)
	public String hello2() {
		return "Hello from the other Side";
	}
}
