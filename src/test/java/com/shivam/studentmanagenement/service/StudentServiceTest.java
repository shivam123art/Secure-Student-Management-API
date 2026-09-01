package com.shivam.studentmanagenement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shivam.studentmanagenement.model.Student;
import com.shivam.studentmanagenement.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testAddStudent() {

        // Arrange
        Student student = new Student();
        student.setId(1);
        student.setName("Shivam");
        student.setMarks(90);

        when(repository.save(student)).thenReturn(student);

        // Act
        Student result = studentService.addStudent(student);

        // Assert
        assertNotNull(result);
        assertEquals("Shivam", result.getName());
        assertEquals(90, result.getMarks());

        // Verify
        verify(repository).save(student);
    }
    @Test
void testGetStudentById() {

    Student student = new Student();
    student.setId(1);
    student.setName("Shivam");
    student.setMarks(90);

    when(repository.findById(1))
            .thenReturn(java.util.Optional.of(student));

    Student result = studentService.getStudentById(1);

    assertNotNull(result);
    assertEquals("Shivam", result.getName());

    verify(repository).findById(1);
}
@Test
void testGetAllStudents() {

    List<Student> students = List.of(
            new Student(),
            new Student()
    );

    when(repository.findAll()).thenReturn(students);

    List<Student> result = studentService.getAllStudents();

    assertEquals(2, result.size());

    verify(repository).findAll();
}
@Test
void testDeleteStudent() {

    when(repository.existsById(1)).thenReturn(true);

    String result = studentService.deleteStudent(1);

    assertEquals("Student deleted successfully", result);

    verify(repository).existsById(1);
    verify(repository).deleteById(1);
}
@Test
void testDeleteStudentNotFound() {

    when(repository.existsById(1)).thenReturn(false);

    String result = studentService.deleteStudent(1);

    assertEquals("Student not found", result);

    verify(repository).existsById(1);
    verify(repository, never()).deleteById(1);
}
@Test
void testUpdateStudent() {

    Student existing = new Student();
    existing.setId(1);
    existing.setName("Old");
    existing.setMarks(70);

    Student updated = new Student();
    updated.setName("Shivam");
    updated.setMarks(90);

    when(repository.findById(1))
            .thenReturn(java.util.Optional.of(existing));

    when(repository.save(existing))
            .thenReturn(existing);

    Student result = studentService.updateStudent(1, updated);

    assertEquals("Shivam", result.getName());
    assertEquals(90, result.getMarks());

    verify(repository).findById(1);
    verify(repository).save(existing);
}
}