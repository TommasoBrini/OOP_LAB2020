package oop.lab03.acme;

import java.util.Arrays;

public class Exam {

	private int id;
	private int maxStudents;
	private int registeredStudents;
	private String courseName;
	private Professor professor;
	private ExamRoom room;
	private Student[] students;
	
	public Exam(int id, int maxStudents, String courseName, Professor professor, ExamRoom room) {
		this.id = id;
		this.maxStudents = maxStudents;
		this.courseName = courseName;
		this.professor = professor;
		this.room = room;
		this.registeredStudents = 0;
		this.students = new Student[0];
	}

	public int getId() {
		return id;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public int getRegisteredStudents() {
		return registeredStudents;
	}

	public String getCourseName() {
		return courseName;
	}

	public Professor getProfessor() {
		return professor;
	}

	public ExamRoom getRoom() {
		return room;
	}

	public Student[] getStudents() {
		return students;
	}

	private void expand() {
        students = Arrays.copyOf(students, students.length + 1);
    }
	
	public void registerStudent(Student student) {
		if(this.registeredStudents < this.maxStudents) {
			expand();
			this.students[registeredStudents] = student;
			this.registeredStudents++;	
		}
	}

	public String toString() {
		return "Exam [id=" + id + ", maxStudents=" + maxStudents + ", registeredStudents=" + registeredStudents
				+ ", courseName=" + courseName + ", professor=" + professor + ", room=" + room + ", students="
				+ Arrays.toString(students) + "]";
	}
	
	
	
}
