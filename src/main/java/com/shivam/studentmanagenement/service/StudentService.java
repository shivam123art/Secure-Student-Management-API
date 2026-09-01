package com.shivam.studentmanagenement.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.studentmanagenement.model.Student;
import com.shivam.studentmanagenement.repository.StudentRepository;
import com.shivam.studentmanagenement.dto.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@Service
public class StudentService {
   private static final Logger logger =
        LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepository repository;

public Student addStudent(Student student) {

    logger.info("Adding student: {}", student.getName());

    Student savedStudent = repository.save(student);

    logger.info("Student added successfully with ID: {}", savedStudent.getId());

    return savedStudent;
}

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {

    logger.info("Searching student with ID: {}", id);

    Student student = repository.findById(id).orElse(null);

    if (student == null) {
        logger.warn("Student not found with ID: {}", id);
    }

    return student;
}

    public Student updateStudent(int id, Student student) {
        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setMarks(student.getMarks());
            return repository.save(existingStudent);
        }

        return null;
    }

    public String deleteStudent(int id) {

    logger.info("Deleting student with ID: {}", id);

    if (repository.existsById(id)) {

        repository.deleteById(id);

        logger.info("Student deleted successfully with ID: {}", id);

        return "Student deleted successfully";
    }

    logger.warn("Student not found with ID: {}", id);

    return "Student not found";
}
    public List<Student> getStudentByName(String name) {
        return repository.findByName(name);
}
public List<Student> getStudentBYNameAndMarks(String name,int marks){
    return repository.findByNameAndMarks(name, marks);
}
public List<Student> getStudentsWithMarksGreaterThan(int marks){
    return repository.findByMarksGreaterThan( marks );
}
public List<Student> searchStudentByName(String name){
    return repository.findByNameContaining(name);
}
public Student getTopStudent() {
    return repository.findTopByOrderByMarksDesc();
}
@Autowired
private ModelMapper modelMapper;
public List<StudentDTO> getAllStudentDTOs(){
    return repository.findAll().stream().map(student -> modelMapper.map(student, StudentDTO.class)).toList();
}
public Page<Student> getStudents(Pageable pageable){
    return repository.findAll(pageable);
}
public List<Student> getStudentsSorted(String field){
    return repository.findAll(Sort.by(field));
}
public List<Student> getStudentsByMarksJPQL(int marks){
    return repository.getStudentByMarksJPQL(marks);
}
public List<Student> getStudentByNameAndMarksJPQL(String name , int marks){
    return repository.getStudentByNameAndMarksJPQL(name,marks);
}
public List<Student> getStudentsByMarksNative(int marks){
    return repository.getStudentsByMarksNative(marks);
}

}
