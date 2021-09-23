package com.hibernate2;

public class Student {
	private int id;
	private String studentfirstname;
	private String studentlastname;
	private int rollno;
	private String course;


	public Student() {
	}

	public Student(String studentfirstname, String studentlastname, int rollno , String course) {
		super();

		this.studentfirstname = studentfirstname;
		this.studentlastname = studentlastname;
		this.rollno = rollno;
		this.course =course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getStudentfirstname() {
		return studentfirstname;
	}

	public void setStudentfirstname(String studentfirstname) {
		this.studentfirstname = studentfirstname;
	}

	public String getStudentlastname() {
		return studentlastname;
	}

	public void setStudentlastname(String studentlastname) {
		this.studentlastname = studentlastname;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	}