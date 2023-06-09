package com.parshuram.studentrest.repository;

import com.parshuram.studentrest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findByCity(String city);

    public Optional<Student> findByRollNumber(Integer rollNumber);



}
