package Hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private int sid;
    private String sname;
    private String city;
    private double cgp;

    public Student(int sid, String sname, String city, double cgp) {
        this.sid = sid;
        this.sname = sname;
        this.city = city;
        this.cgp = cgp;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getCity() {
        return city;
    }

    public double getCgp() {
        return cgp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", city='" + city + '\'' +
                ", cgp=" + cgp +
                '}';
    }
}



public class Main {
	
	    public static void main(String[] args) {
	        List<Student> students = new ArrayList<>();
	        students.add(new Student(1, "Anjali", "Hyderabad", 9.8));
	        students.add(new Student(2, "Manju", "Los Angeles", 3.5));
	        students.add(new Student(3, "Tom", "USA", 6.9));
	        students.add(new Student(4, "Tony", "France", 6.6));
	        students.add(new Student(5, "Eva", "San Francisco", 7.0));
	        students.add(new Student(6, "Naruto", "Japan", 8.7));

	        System.out.println("Sorting by name:");
	        Collections.sort(students, Comparator.comparing(Student::getSname));
	        printStudents(students);

	        System.out.println("\nSorting by CGP:");
	        Collections.sort(students, Comparator.comparingDouble(Student::getCgp));
	        printStudents(students);
	    }

	    private static void printStudents(List<Student> students) {
	        for (Student student : students) {
	            System.out.println(student);
	        }
	    }
	}


