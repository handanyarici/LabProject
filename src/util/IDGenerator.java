package util;

public class IDGenerator {
	public static int studentID=1;
	public static int generateStudentID() {
		return studentID++;
	}
}
