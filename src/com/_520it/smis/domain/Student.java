package com._520it.smis.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
public class Student {
	private Long id;
	private String name;
	private Integer age;
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]\n";
	}
	
}
