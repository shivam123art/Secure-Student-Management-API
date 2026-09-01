package com.shivam.studentmanagenement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shivam.studentmanagenement.dto.StudentDTO;
import com.shivam.studentmanagenement.model.Student;
import com.shivam.studentmanagenement.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody Student student) {

        return new ResponseEntity<>(
                service.addStudent(student),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable int id) {

        return ResponseEntity.ok(
                service.getStudentById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody Student student) {

        return ResponseEntity.ok(
                service.updateStudent(id, student)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable int id) {

        return ResponseEntity.ok(
                service.deleteStudent(id)
        );
    }

    @GetMapping("/name/{name}")
    public List<Student> getStudentByName(
            @PathVariable String name) {

        return service.getStudentByName(name);
    }

    @GetMapping("/name/{name}/marks/{marks}")
    public List getStudentByNameAndMarks(
            @PathVariable String name,
            @PathVariable int marks) {

        return service.getStudentBYNameAndMarks(name, marks);
    }

    @GetMapping("/marks/greater/{marks}")
    public List getStudentsWithMarksGreaterThan(
            @PathVariable int marks) {

        return service.getStudentsWithMarksGreaterThan(marks);
    }

    @GetMapping("/search/{name}")
    public List searchStudentByName(
            @PathVariable String name) {

        return service.searchStudentByName(name);
    }

    @GetMapping("/top")
    public Student getTopStudent() {
        return service.getTopStudent();
    }

    @GetMapping("/dto")
    public List getAllStudentDTOs() {
        return service.getAllStudentDTOs();
    }

    @GetMapping("/page")
    public Page getStudents(Pageable pageable) {
        return service.getStudents(pageable);
    }

    @GetMapping("/sort/{field}")
    public List getStudentsSorted(
            @PathVariable String field) {

        return service.getStudentsSorted(field);
    }

    @GetMapping("/jpql/marks/{marks}")
    public List getStudentsByMarksJPQL(
            @PathVariable int marks) {

        return service.getStudentsByMarksJPQL(marks);
    }

    @GetMapping("/jpql/{name}/{marks}")
    public List getStudentByNameAndMarksJPQL(
            @PathVariable String name,
            @PathVariable int marks) {

        return service.getStudentByNameAndMarksJPQL(name, marks);
    }

    @GetMapping("/native/marks/{marks}")
    public List getStudentsByMarksNative(
            @PathVariable int marks) {

        return service.getStudentsByMarksNative(marks);
    }
}