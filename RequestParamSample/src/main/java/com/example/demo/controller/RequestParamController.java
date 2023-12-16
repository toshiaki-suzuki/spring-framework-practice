package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {
	/** 入力画面を表示する */
	@GetMapping("show")
	public String showView() {
		// 戻り値は「ビュー名」を返す
		return "entry";
	}
	/** 確認画面を表示する */
	@PostMapping("confirm") // Postメソッドを取得
	public String confirmView(
			Model model,
			@RequestParam String name, // リクエストパラメータを取得
			@RequestParam Integer age,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
			@RequestParam LocalDate birth
			) {
		// Modelに格納する
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("birth", birth);
		// 戻り値は「ビュー名」を返す
		return "confirm";
	}
}