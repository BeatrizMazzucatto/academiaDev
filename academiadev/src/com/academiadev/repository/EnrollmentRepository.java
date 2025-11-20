package com.academiadev.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.academiadev.model.Enrollment;
import com.academiadev.model.Student;
import com.academiadev.model.Course;

public interface EnrollmentRepository {

    void save(Enrollment enrollment);
    void delete(Enrollment enrollment);
    
    Optional<Enrollment> findByStudentAndCourse(Student student, String courseTitle);
    List<Enrollment> findByStudent(Student student);
    List<Enrollment> findByCourse(Course course);
    
    Collection<Enrollment> findAll();
    boolean existsByStudentAndCourse(Student student, String courseTitle);

    
}

