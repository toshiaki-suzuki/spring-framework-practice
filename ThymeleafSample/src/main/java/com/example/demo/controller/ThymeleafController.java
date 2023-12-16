package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Member;

@Controller
public class ThymeleafController {

	@GetMapping("show")
	public String showView(Model model) {
		// Memberを作成
		Member member = new Member(1, "会員01");
		// コレクション格納用：Memberを作成
		Member member1 = new Member(10, "田中");
		Member member2 = new Member(20, "鈴木");
		// Listを作成
		List<String> directionList = new ArrayList<>();
		directionList.add("東");
		directionList.add("西");
		directionList.add("南");
		directionList.add("北");
		// Mapを作成し、Memberを格納
		Map<String, Member> memberMap = new HashMap<>();
		memberMap.put("tanaka", member1);
		memberMap.put("suzuki", member2);
		// Listを作成し、Memberを格納
		List<Member> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);
		// 「Model」にデータを格納する
		model.addAttribute("name", "太郎");
		model.addAttribute("mb", member);
		model.addAttribute("list", directionList);
		model.addAttribute("map", memberMap);
		model.addAttribute("members", memberList);
		// 戻り値は「ビュー名」を返す
		return "useThymeleaf";
	}
}