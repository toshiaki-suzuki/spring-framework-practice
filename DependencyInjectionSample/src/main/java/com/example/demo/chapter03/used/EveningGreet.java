package com.example.demo.chapter03.used;

import org.springframework.stereotype.Component;

@Component
public class EveningGreet implements Greet {

	@Override
	public void greeting() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("こんばんは");
	}

}
