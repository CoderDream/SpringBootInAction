package com.wisely.ch9_1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wisely.ch9_1.domain.Msg;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model){
		Msg msg =  new Msg("娴嬭瘯鏍囬","娴嬭瘯鍐呭","棰濆淇℃伅锛屽彧瀵圭鐞嗗憳鏄剧ず");
		model.addAttribute("msg", msg);
		return "home";
	}

}
