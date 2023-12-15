package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello") // リクエストハンドラメソッドとURLをマッピングする
public class HelloViewController {
	
	// hello/view でアクセスする
	@GetMapping("view")
	public String helloView() {
		return "hello"; // hello.htmlをテンプレートとして返す
	}
}
