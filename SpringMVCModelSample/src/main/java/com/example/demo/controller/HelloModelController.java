package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {
	
	@GetMapping("view")
	public String helloView(Model model) {
		model.addAttribute("msg", "タイムリーフ");
		return "helloThymeleaf";
	}
	
	@GetMapping("use")
	public String useView(Model model) {
		return "useThymeleaf";
	}
	
}
