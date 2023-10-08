package com.example.product_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
