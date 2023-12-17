package com.example.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

@SpringBootApplication
public class QuizApplication {
	/** 起動メソッド */
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args)
				.getBean(QuizApplication.class).execute();
	}
	/** 注入 */
	@Autowired
	QuizRepository repository;
	/** 実行メソッド */
	private void execute() {
		// 登録処理
		setup();
	}
	/** === クイズを2件登録します === */
	private void setup() {
		// エンティティ生成
		Quiz quiz1 = new Quiz(null, "「Spring」はフレームワークですか？", true, "登録太郎");
		// 登録実行
		quiz1 = repository.save(quiz1);
		// 登録確認
		System.out.println("登録したデータは、" + quiz1 + "です。");
		// エンティティ生成
		Quiz quiz2 = new Quiz(null, "「Spring MVC」はバッチ処理機能を提供しますか？",
				false, "登録太郎");
		// 登録実行
		quiz2 = repository.save(quiz2);
		// 登録確認
		System.out.println("登録したデータは、" + quiz2 + "です。");
	}
}