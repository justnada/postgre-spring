package com.amigoscode.startspringboot.student;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "start_spring_boot_sequence",
            sequenceName = "start_spring_boot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "start_spring_boot_sequence"
    )
    private Long id;

    @NotNull(message = "Name could not be empty.")
    private String name;

    @NotNull(message = "Gender could not be empty.")
    private Gender gender;

    @Email
    @NotNull(message = "Email could not be empty.")
    private String email;

    @NotNull(message = "Day of birth could not be empty.")
    private LocalDate dob;

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   Gender gender,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   Gender gender,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
