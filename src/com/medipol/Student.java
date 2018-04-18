package com.medipol;

import util.IDGenerator;

public class Student{
	
	public String name;
	public String studentId;
	public String surname;
	public String group;
	public boolean attendance;
	public double avarageGrade;
	
	
	
	public Student(String name, String surname, String group, boolean attendance, double avarageGrade) {
		super();
		this.name = name;
		this.surname = surname;
		this.group = group;
		this.attendance = attendance;
		this.avarageGrade = avarageGrade;
		this.studentId = String.valueOf(IDGenerator.generateStudentID());
	}

	public Student(String studentId, String name, String surname) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.surname = surname;
		this.group="";
		this.avarageGrade=0;
	}





	public boolean doAssignment(String assignment) { //burasý metot, boolean çünkü ödevi yapmýþ ya da yapmamýþtýr 
		return false;
	}





	@Override
	public String toString() {
		return this.studentId+";"+this.name+";"+this.surname+";"+this.group+";"+this.avarageGrade+";BELIRSIZ;"+this.attendance;
	}

		
}
