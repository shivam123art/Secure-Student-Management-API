package com.shivam.studentmanagenement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivam.studentmanagenement.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.query.*;
import org.springframework.data.repository.query.Param;
public interface StudentRepository extends JpaRepository<Student, Integer> {
List<Student> findByName(String name);
List<Student> findByNameAndMarks(String name, int marks);
List<Student> findByMarksGreaterThan(int marks);
List<Student> findByNameContaining(String name);
List<Student> findByOrderByMarksDesc();
Student findTopByOrderByMarksDesc();
@Query(" SELECT s FROM Student s")
List<Student> getAllStudentsJPQL();
@Query("SELECT s FROM Student s WHERE s.marks > :marks")
List<Student> getStudentByMarksJPQL(@Param("marks") int marks);
@Query("""
        SELECT s FROM Student s
        WHERE s.name = :name
        AND s.marks> :marks
        """)
        List<Student> getStudentByNameAndMarksJPQL(
            @Param("name") String name,
            @Param("marks") int marks
        );
        @Query(
            value =  "SELECT * FROM student WHERE marks > :marks",
            nativeQuery = true
        )
        List<Student> getStudentsByMarksNative(@Param("marks")int marks);
}