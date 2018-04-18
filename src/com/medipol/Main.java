package com.medipol;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School school = new School("Medipol", "kavacik","0216423423432");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ogrenci adý Gir");
		String name = scanner.nextLine();	
		System.out.println("Ogrenci soyadi Gir");
		String surname = scanner.nextLine();	
		scanner.close();
		
		Student student1 = new Student(name,surname,"",true,0.0);
		school.addStudent(student1);	
		
		for(Student s : school.getAllStudents()) {
			System.out.println(s.toString());
		}
		
	}

}
