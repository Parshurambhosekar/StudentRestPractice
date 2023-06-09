package com.parshuram.studentrest.controller;

import com.parshuram.studentrest.binding.ApiResponse;
import com.parshuram.studentrest.binding.StudentDto;
import com.parshuram.studentrest.constants.AppConstants;
import com.parshuram.studentrest.entity.Student;
import com.parshuram.studentrest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/welcome")
    public String getMessage(){

        return "Hi We Deployed Student Service ON AWS..........";
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDto studentDto){

        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentDto studentDto,@PathVariable(name = "number") Integer rollNumber){

        return new ResponseEntity<>(studentService.updateStudent(studentDto,rollNumber),HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudentDetails(){

        return new ResponseEntity<>(studentService.viewAllStudentDetails(),HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable(name = "number") Integer rollNumber){

        studentService.deleteStudent(rollNumber);

        return new ResponseEntity<>(new ApiResponse(AppConstants.MESSAGE),HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<Student>> getStudentByState(@PathVariable String state){

        return new ResponseEntity<>(studentService.getStudentByState(state),HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Student>> getStudentByCity(@PathVariable String city){

        return new ResponseEntity<>(studentService.getStudentByCity(city),HttpStatus.OK);
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<Student> getStudentByRollNumber(@PathVariable(name = "number") Integer rollNumber){

        return new ResponseEntity<>(studentService.getStudentByRollNumber(rollNumber),HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable(name = "name") String firstname){

        return new ResponseEntity<>(studentService.getStudentByName(firstname),HttpStatus.OK);
    }

    @GetMapping("/lname/{name}")
    public ResponseEntity<List<Student>> getStudentByLastName(@PathVariable(name = "name") String lastname){

        return new ResponseEntity<>(studentService.getStudentByLastname(lastname),HttpStatus.OK);
    }


}
