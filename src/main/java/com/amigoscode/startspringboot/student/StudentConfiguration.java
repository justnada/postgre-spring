package com.amigoscode.startspringboot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner runner(
            StudentRepository studentRepository) {
                return args -> {
                    List<Student> students = List.of(
                            new Student(
                                    "Jamaika",
                                    Gender.FEMALE,
                                    "jamaika@gmail.com",
                                    LocalDate.of(2000, Month.DECEMBER, 12)
                            ),
                            new Student(
                                    "Peter",
                                    Gender.MALE,
                                    "peter@gmail.com",
                                    LocalDate.of(2011, Month.JUNE, 15)
                            )
                    );

                    studentRepository.saveAll(students);
                };
    }

}
