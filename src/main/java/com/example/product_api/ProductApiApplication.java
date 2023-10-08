package com.example.product_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.product_api.repository.StudentRepository;
import com.example.product_api.entity.Student;

@SpringBootApplication
public class ProductApiApplication { // Cette classe ce lance au serveur

	StudentRepository studentRepositoryFromApplication;

	public ProductApiApplication(StudentRepository studentRepositoryFromApplication) {
		this.studentRepositoryFromApplication = studentRepositoryFromApplication;

	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
		System.out.println("Hello server");
	}

	@Bean
	public CommandLineRunner run() throws Exception { // elle s'active quand la classe est instancié
		return (String[] args) -> {

			System.out.println("Hello serverss lancer from commandline Runner");
			Student Lucas = new Student("Lucas", 25, "frontend");
			Student jamal = new Student("Jamal", 33, "frontend");
			Student richard = new Student("Richard", 48, "frontend");
			Student tawfik = new Student("Tawfik", 50, "backend");
			Student Omar = new Student("Omar", 28, "backend");

			List<Student> studentList = new ArrayList<Student>();

			studentList.add(jamal);
			studentList.add(tawfik);
			studentList.add(Lucas);
			studentList.add(richard);
			studentList.add(Omar);

			this.studentRepositoryFromApplication.saveAll(studentList);

		};

	}

}
