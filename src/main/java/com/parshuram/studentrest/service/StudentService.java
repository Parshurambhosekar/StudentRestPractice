package com.parshuram.studentrest.service;

import com.parshuram.studentrest.binding.StudentDto;
import com.parshuram.studentrest.entity.Student;

import java.util.List;

public interface StudentService {

    public Student createStudent(StudentDto studentDto);

    public Student updateStudent(StudentDto studentDto,Integer rollNumber);

    public void deleteStudent(Integer rollNumber);

    public List<Student> viewAllStudentDetails();

    public List<Student> getStudentByState(String state);

    public List<Student> getStudentByCity(String city);

    public Student getStudentByRollNumber(Integer rollNumber);

    public Student getStudentByName(String firstname);

    public List<Student> getStudentByLastname(String lastname);

}
