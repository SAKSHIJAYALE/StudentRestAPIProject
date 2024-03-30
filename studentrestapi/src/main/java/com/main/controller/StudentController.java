package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Student;
import com.main.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getAlll")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping("/addStudent")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        updatedStudent.setId(id);
        return studentRepository.save(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}


