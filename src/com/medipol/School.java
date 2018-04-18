package com.medipol;

import java.util.ArrayList;
import java.util.List;

import util.FileUtils;

public class School{
	public String name;
	public String address;
	public String phone="90324234";
	
	
	
	public School(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public void addStudent(Student student) {
		FileUtils.writeFile(student.toString());
	}
	
	public void removeStudent(Student student) {
		
	}
	
	public Student getStudent(int studentID) {
		return null; // ??
}
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		String fileContent = FileUtils.readFile();
		String[] satirlar = fileContent.split("\n");
		for(String satir:satirlar) {
			 String[] arr = satir.split(";");
             Student s = new Student(arr[0], arr[1], arr[2]);
             students.add(s);
		}
		return students;
	}

	public void addDepartment(Department department) {
	}
	
	public void removeDepartment(Department department) {
		
	}
	
	public Department getDepartment(int departmentId) {
		return null; // ??
	}
	
	public Department[] getAllDepartments() {
		return null; // ??
		
	}
}