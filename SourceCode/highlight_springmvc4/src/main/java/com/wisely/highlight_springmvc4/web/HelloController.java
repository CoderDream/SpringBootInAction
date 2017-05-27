package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//1
public class HelloController {
	
	//@RequestMapping("/index") // 2
	@RequestMapping(value = { "/" }) // 3 设置成首页
	public String hello() {
		return "index";
	}

}
