package com._520it.smis.test;


import java.util.List;

import org.junit.Test;

import com._520it.smis.dao.IStudentDAO;
import com._520it.smis.dao.impl.StudentDAOImpl;
import com._520it.smis.domain.Student;

public class IStudentDAOTest {
	private  IStudentDAO dao=new StudentDAOImpl();

	@Test
	public void testSave() {
		 Student stu =new Student();
		 stu.setAge(12);
		 stu.setName("元尊");
		 dao.save(stu);
	}

	@Test
	public void testDelete() {
		dao.delete(37L);;
	}

	@Test
	public void testUpdate() {
		 Student stu =new Student();
		 stu.setAge(122);
		 stu.setName("郭靖");
		 dao.update(1L,stu);
	}

	@Test
	public void testGet() {
		Student student=dao.get(2L);
		System.out.println(student.toString());
	}

	@Test
	public void testListall() {
		List<Student> student = dao.listall();
		System.out.println(student.toString());
	}

}
