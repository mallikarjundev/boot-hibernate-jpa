package com.luv2code.curddemo;

import com.luv2code.curddemo.dao.StudentDAO;
import com.luv2code.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			readStudent(studentDAO);
		};

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
