package com.hibernate2;


	import java.util.ArrayList;
	import java.util.List;

	import service.StudentService;

	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;



	public class ManageStudent {


		public static void main(String[] args) {

			StudentService studentService = new StudentService();

			/* Add few Student records in database */
			Integer studentID1 = studentService.addStudent("Abhinav", "Sharma", 101, "B.tech");// asssinged values from here
			Integer studentID2 = studentService.addStudent("Aman", "kumar", 102,"B.tech");// asssinged values from here

			List<Integer> listinfo = new ArrayList<Integer>();

			listinfo.add(studentID1);
			listinfo.add(studentID2);

			if (listinfo.size() != 0) {
				System.out.println("*************************************Inserted******************************");
			} else {
				System.out.println("##############not Inserted########################");

			}

			/* list employee records in database */
			try {
				studentService.ListAllStudent();
			} catch (Exception e) {

				e.printStackTrace();
			}

		//	 update employee records in database 
			try {
				studentService.updateStudentDetails(2,"BA");
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			//delete student records in database by id */
			try {
			studentService.deleteStudentDetailsById(1,101);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}