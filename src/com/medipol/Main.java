package com.medipol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.medipol.sort.MyQuickSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School school = new School("Medipol", "kavacik","0216423423432");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ogrenci ad� Gir");
		String name = scanner.nextLine();	
		System.out.println("Ogrenci soyadi Gir");
		String surname = scanner.nextLine();	
		scanner.close();
		
		Student student1 = new Student(name,surname,"",true,0.0);
//		school.addStudent(student1);	
		
		List<Student> sortedStudents = school.getAllStudents();
//		Arrays.sort(sortedStudents);
//		for(Student s : sortedStudents) {
//			System.out.println(s.toString());
//		}
		
		Set s = new HashSet<Student>();
		s.add(student1);
	//	s.add(student1);
		
		Iterator i = s.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}
//		
//		MyQuickSort quickSort = new MyQuickSort();
//		quickSort.sort(sortedStudents);
//		
//		System.out.println(Arrays.toString(sortedStudents));
//		Student s = new Student(45);
//		int index = Arrays.binarySearch(sortedStudents, s);
//		System.out.println(sortedStudents[index]);
		
		
//		System.out.println(sortedStudents[Arrays.binarySearch(sortedStudents, new Student(99))]);
		
	}

}
