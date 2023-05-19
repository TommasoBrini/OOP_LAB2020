package oop.lab03.acme;

import java.util.Arrays;

public class Professor implements User {

	private static final String DOT = ".";
	private int id;
	private String name;
	private String surname;
	private String password;
	private String[] courses;

	public Professor(int id, String name, String surname, String password, String[] courses) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.courses = courses;
	}

	public String getUsername() {
		return this.name + Professor.DOT + this.surname;
	}

	public String getPassword() {
		return this.password;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public String getDescription() {
		return this.toString();
	}

	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password
				+ ", courses=" + Arrays.toString(courses) + "]";
	}

	public void replaceCourse(String course, int index) {
		this.courses[index] = course;
	}
	
	public void replaceAllCourses(String[] courses) {
		this.courses = Arrays.copyOf(courses, courses.length);
	}
	

}
