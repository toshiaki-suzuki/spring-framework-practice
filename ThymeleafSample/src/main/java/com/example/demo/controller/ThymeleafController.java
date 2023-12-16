package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

	@GetMapping("show") // /show へのリクエストを処理
	public String showView(Model model) {
		// 戻り値は「ビュー名」を返す
		model.addAttribute("name", "太郎");
		return "useThymeleaf";
	}
}