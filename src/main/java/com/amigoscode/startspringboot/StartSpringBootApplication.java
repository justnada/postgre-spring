package com.amigoscode.startspringboot;

import com.amigoscode.startspringboot.student.Gender;
import com.amigoscode.startspringboot.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = com.amigoscode.startspringboot.student.StudentRepository.class)
public class StartSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootApplication.class, args);
	}
}
