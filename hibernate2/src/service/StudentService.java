package service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate2.Student;

import hibernate.util.HibernateUtil;

public class StudentService {

	static SessionFactory sessionFactoryObj;
	static Session sessionObj;

	//////////////// POST request//////////////////////////////////////////

	/* Method to CREATE an student in the database business logic */
	public Integer addStudent(String fname, String lname, int rollno , String course) {

		Transaction tx = null;
		Integer studentID = null;

		try {

			sessionObj = HibernateUtil.buildSessionFactory().openSession();
			tx = sessionObj.beginTransaction();

			Student student = new Student(fname, lname, rollno,course);// created the object of employee class
			studentID = (Integer) sessionObj.save(student); // save the object or insert the recording

			tx.commit();// explictiy call the commit esure that auto commite should be false
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return studentID;
	}

	//////////////// GET request//////////////////////////////////////////

	// list

	/* Method to CREATE an Student in the database business logic */
	public void ListAllStudent() {
		System.out.println(" *************from inside  ListAllStudent()**********************  ");
		Transaction tx = null;
		try {

			sessionObj = HibernateUtil.buildSessionFactory().openSession();
			tx = sessionObj.beginTransaction();
			// retrive logic
			List student = sessionObj.createQuery("From student").list(); // select * from employee: "Employee refer
																				// Employee class
			Iterator iterator = student.iterator();
			while (iterator.hasNext()) {
			//	Student student1 = (student) iterator.next();
				Student student1=(Student) iterator.next();
				System.out.println("student fist  name  " + student1.getStudentfirstname());
				System.out.println("student last  name  " + student1.getStudentlastname());
				System.out.println("student  rollno    " + student1.getRollno());
				System.out.println("student  course    "+student1.getCourse());
			}

			tx.commit();// explictiy call the commit esure that auto commite should be false
		} catch (

		HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
	}

// update

////////////////PUT request   id//////////////////////////////////////////

	/* Method to update an Student in the database business logic */
	public void updateStudentDetails(Integer StudentId, String course) {
		System.out.println(" *************from inside  updateStudentDetails()**********************  ");
		Transaction tx = null;
		try {

			sessionObj = HibernateUtil.buildSessionFactory().openSession();
			tx = sessionObj.beginTransaction();
			// update logic

			Student student = (Student) sessionObj.get(Student.class, StudentId);

			student.setCourse(course);

			sessionObj.update(student);// hibernate will form update query automatically

			System.out.println("update sucessfully..."+student.getId());

			tx.commit();// explictiy call the commit esure that auto commite should be false
		} catch (

		HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}

	}

// delete

////////////////PUT request   id//////////////////////////////////////////

	// Method to update an Student in the database business logic 
	public void deleteStudentDetailsById(Integer StudentId, Integer rollno) {
		System.out.println(" *************from inside  deleteEmployeeDetailsById()**********************  ");
		Transaction tx = null;
		try {

			sessionObj = HibernateUtil.buildSessionFactory().openSession();
			tx = sessionObj.beginTransaction();
//update logic

			Student student = (Student) sessionObj.get(Student.class, StudentId);

			student.setRollno(rollno);

			sessionObj.delete(student);// hibernate will form delete query automatically

			System.out.println("deleted sucessfully..."+student.getId());

			tx.commit();// explictiy call the commit esure that auto commite should be false
		} catch (

		HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}

	}}