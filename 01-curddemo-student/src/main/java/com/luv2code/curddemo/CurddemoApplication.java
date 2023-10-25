package com.luv2code.curddemo;

import com.luv2code.curddemo.dao.StudentDAO;
import com.luv2code.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			updateStudent(studentDAO);
		};

		}

	private void updateStudent(StudentDAO studentDAO) {
		// retrive student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to"scoby"
		System.out.println("updating student...");
		myStudent.setFirstName("scoby");

		//update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("updated: "+myStudent);

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get list of students
		List<Student> students = studentDAO.findAll();

		// display the list
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("creating student objects...");

		Student tempStudent1 = new Student("ab", "o","ak@gmail.com");


		// save the student object
		System.out.println("saving the object");
		studentDAO.save(tempStudent1);

		// display id of the saved student
		int theId = tempStudent1.getId();
		System.out.println("saved student generated Id: " + theId);

		// retrieve student based on id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("found student: "+ myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("creating 3 student objects...");

		Student tempStudent1 = new Student("ab", "o","ak@gmail.com");
		Student tempStudent2 = new Student("Ar", "k","ak1@gmail.com");
		Student tempStudent3 = new Student("jun", "m","akhm@gmail.com");

		// save the student objects
		System.out.println("saving student objects");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}



	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("Arjun", "o","ak@gmail.com");

		// save the student object
		System.out.println("saving the object");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}
}
