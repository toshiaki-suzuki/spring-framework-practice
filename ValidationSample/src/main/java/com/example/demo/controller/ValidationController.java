package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.CalcForm;
import com.example.demo.validatior.CalcValidator;

@Controller
public class ValidationController {
	/** 「form-backing bean」の初期化 */
	@ModelAttribute
	public CalcForm setUpForm() {
		return new CalcForm();
	}
	/** 入力画面を表示する */
	@GetMapping("show")
	public String showView() {
		// 戻り値は「ビュー名」を返す
		return "entry";
	}
	/** 確認画面を表示する：Formクラス使用 */
	@PostMapping("calc")
	public String confirmView(
			@Validated CalcForm form, // Formクラスに従ってバリデーション
			BindingResult bindingResult, // バリデーションの結果を保持
			Model model) {
		// 入力チェックされた場合
		if (bindingResult.hasErrors()) {
			// 入力画面へ
			return "entry";
		}
		// 加算実行
		Integer result = form.getLeftNum() + form.getRightNum();
		// Modelに格納する
		model.addAttribute("result", result);
		// 確認画面へ
		return "confirm";
	}
	/** インジェクション */
	@Autowired
	CalcValidator calcValidator;
	/** 相関チェック登録 */
	@InitBinder("calcForm")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(calcValidator);
	}
}