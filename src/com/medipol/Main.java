package com.medipol;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School school = new School("Medipol", "kavacik","0216423423432");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Ogrenci ad� Gir");
//		String name = scanner.nextLine();	
//		System.out.println("Ogrenci soyadi Gir");
//		String surname = scanner.nextLine();	
//		scanner.close();
		
//		Student student1 = new Student(name,surname,"",true,0.0);
//		school.addStudent(student1);	
		
		Student[] sortedStudents = school.getAllStudents();
		Arrays.sort(sortedStudents);
//		for(Student s : sortedStudents) {
//			System.out.println(s.toString());
//		}
		
		
		System.out.println(sortedStudents[Arrays.binarySearch(sortedStudents, new Student(99))]);
		
	}

}
