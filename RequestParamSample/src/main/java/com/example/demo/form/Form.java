package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Form {
	private String name;
	private Integer age;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // ISOフォーマットの日付として取得
	private LocalDate birth;
}
