package com.example.product_api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.product_api.entity.Student;
import com.example.product_api.repository.StudentRepository;

@Controller
public class StudentController {

  @GetMapping("/student")
  @ResponseBody // c'est une anotation qui spécifié qu'il veut recevoir la réponse au format
                // JSON
  public Map<String, String> getStudent() {
    Map<String, String> objet = new HashMap<String, String>();
    objet.put("name", "John");
    objet.put("age", "23");
    objet.put("speciality", "frontend");
    return objet;

  }

  private StudentRepository studentRepository;

  public StudentController(StudentRepository studentRepository) { // c'est l'équivalent du AutoWired
    this.studentRepository = studentRepository;
  }

  @GetMapping("/student2")
  @ResponseBody
  public List<Student> getStudent2() {
    List<Student> studentList = studentRepository.findAll();
    return studentList;
  }

  @GetMapping("/student/{id}")
  @ResponseBody
  public Student getUser(@PathVariable int id) {

    Student studentById = studentRepository.findById(id).get();
    return studentById;

  }

  // En requestParam

  @GetMapping("/student3")
  @ResponseBody
  public Student getUserById(@RequestParam int id) {
    return this.studentRepository.findById(id).get();

  }

  @GetMapping("/students")
  @ResponseBody
  public Student updateStudent(@PathVariable int id) {

    Optional<Student> studentToUpdateOptional = this.studentRepository.findById(id);
    if (studentToUpdateOptional.isPresent()) {
      Student studentToUpdate = studentToUpdateOptional.get();
      studentToUpdate.setName("Aurélie");
      return this.studentRepository.save(studentToUpdate);

    }

    else {
      throw new RuntimeException("EEEEEERRRRRRRRRRROOOOOOOOOOORRROUAISOUAISOUAIS");
    }

  }

}
