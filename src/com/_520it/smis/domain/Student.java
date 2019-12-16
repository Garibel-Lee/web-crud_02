package com._520it.smis.domain;



import hibernate.Id;
import hibernate.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table("t_student")
public class Student {
	@Id
	private Long id;
	private String name;
	private Integer age;

	public Student() {
	}

	public Student(String name, Integer age) {
		this.age=age;
		this.name=name;
	}

	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]\n";
	}

}
