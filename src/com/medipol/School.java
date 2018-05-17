package com.medipol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.medipol.util.FileUtils;

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
//	public Student[] getAllStudents() {
//		String fileContent = FileUtils.readFile();
//		String[] satirlar = fileContent.split("\n");
//		Student[] studentArr = new Student[satirlar.length];
//		int i = 0;
//		for(String satir:satirlar) {
//			 String[] arr = satir.split(";");
//             Student s = new Student(arr[0], arr[1], arr[2],arr[5], Double.valueOf(arr[4]),Boolean.valueOf(arr[6]));
//             studentArr[i]= s;
//             i++;
//		}
//		return studentArr;
//	}
	
	public List<Student> getAllStudents() {
		String fileContent = FileUtils.readFile();
		String[] satirlar = fileContent.split("\n");
		List<Student> studentList = new ArrayList<Student>();
		for(String satir:satirlar) {
			 String[] arr = satir.split(";");
             Student s = new Student(arr[0], arr[1], arr[2],arr[5], Double.valueOf(arr[4]),Boolean.valueOf(arr[6]));
             studentList.add(s);
		}
		return studentList;
	}

	public HashMap<String,Student> getAllStudentsWithMap() {
		String fileContent = FileUtils.readFile();
		String[] satirlar = fileContent.split("\n");
		HashMap<String,Student> studentMap = new HashMap<String,Student>();
		for(String satir:satirlar) {
			 String[] arr = satir.split(";");
             Student s = new Student(arr[0], arr[1], arr[2],arr[5], Double.valueOf(arr[4]),Boolean.valueOf(arr[6]));
             studentMap.put(arr[0], s);
		}
		return studentMap;
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

	public Student searchStudent(String studentNumber) {
		long start = System.currentTimeMillis();
		Iterator<Student> it = getAllStudents().iterator();
		while(it.hasNext()) {
			Student temp = it.next();
			if(temp.studentId.equalsIgnoreCase(studentNumber)) {
				long end = System.currentTimeMillis();
				System.out.println("search student calısma süresi: " + (end -start));
				return temp;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("search student calısma süresi: " + (end -start));
		return null;
	}
	
	public Student searchStudentWithMap(String studentNumber) {
		long start = System.currentTimeMillis();
		Iterator it = getAllStudentsWithMap().entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			Student temp = (Student) pair.getValue();
			if(temp.studentId.equalsIgnoreCase(studentNumber)) {
				long end = System.currentTimeMillis();
				System.out.println("search student with Map calısma süresi: " + (end -start));
				return temp;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("search student with Map calısma süresi: " + (end -start));
		return null;
	}
}