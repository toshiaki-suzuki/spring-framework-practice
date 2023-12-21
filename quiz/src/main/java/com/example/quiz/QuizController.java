package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.quiz.entity.Quiz;
import com.example.quiz.form.QuizForm;
import com.example.quiz.service.QuizService;

/** Quizコントローラー */
@Controller
@RequestMapping("/quiz")
public class QuizController {
	/** DI対象 */
	@Autowired
	QuizService service;
	/** 「form-backing bean」の初期化 */
	@ModelAttribute
	public QuizForm setUpForm() {
		QuizForm form = new QuizForm();
		// ラジオボタンのデフォルト値設定
		form.setAnswer(true);
		return form;
	}
	/** Quizの一覧を表示します */
	@GetMapping
	public String showList(QuizForm quizForm, Model model) {
		//新規登録設定
		quizForm.setNewQuiz(true);
		//掲示板の一覧を取得する
		Iterable<Quiz> list = service.selectAll();
		// 表示用「Model」への格納
		model.addAttribute("list", list);
		model.addAttribute("title", "登録用フォーム");
		return "crud";
	}
}