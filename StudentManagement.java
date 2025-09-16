package com;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagement {
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static Scanner scan = new Scanner(System.in);

	public static void addStudent() {
		System.out.println("Enter ID: ");
		int id = scan.nextInt();
		scan.nextLine();

		System.out.println("Enter Name: ");
		String name=scan.nextLine();

		System.out.println("Enter Grade: ");
		double grade=scan.nextDouble();

		students.add(new Student(id,name,grade));
		System.out.println("Student added.\n");
	}
	public static void removeStudent() {
		System.out.println("Enter ID to remove: ");
		int id = scan.nextInt();

		boolean removed = false;
		for(Student s:students) {
			if(s.getId()==id) {
				students.remove(s);
				System.out.println("Student removed.\n");
				removed = true;
				break;
			}
		}
		if(!removed) {
			System.out.println("Student with ID" + id + " not found.\n");
		}
	}
	public static void displayStudents(){
		if(students.isEmpty()) {
			System.out.println("No students found.\n");
		}else {
			System.out.println("Student List");
			for(Student s:students) {
				System.out.println(s);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		students.add(new Student(1,"akash",85.75));
		students.add(new Student(2,"raju",90.0));

		int choice;
		do {
			System.out.println("====Student Management System====");
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. Display Student");
			System.out.println("0. Exit");
			System.out.println("Enter choice: ");

			choice = scan.nextInt();
			switch(choice) {
			case 1:
				addStudent();break;
			case 2:
				removeStudent();
				break;
			case 3:
				displayStudents();
				break;
			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice. try again with correct choice.\n");
			}

		}while(choice!=0);
	}

}
