package com.example.product_api.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

import jakarta.persistence.*;

// @GeneratedValue (strategy = GenerationType.IDENTITY)

@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  private int age;
  private String speciality; // soit front soit back soit fullstack

  public Student() {
  }

  public Student(String name, int age, String speciality) {
    this.name = name;
    this.age = age;
    this.speciality = speciality; // Le constructeur c'est ce qu'initialise en premier dans une classe
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public void save(Student studentList) {
  }
}
