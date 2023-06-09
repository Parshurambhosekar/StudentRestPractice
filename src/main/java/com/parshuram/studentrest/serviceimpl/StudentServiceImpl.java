package com.parshuram.studentrest.serviceimpl;

import com.parshuram.studentrest.binding.StudentDto;
import com.parshuram.studentrest.constants.AppConstants;
import com.parshuram.studentrest.entity.Student;
import com.parshuram.studentrest.exception.StudentNotFoundException;
import com.parshuram.studentrest.repository.StudentRepository;
import com.parshuram.studentrest.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentDto studentDto) {

        Random random=new Random();
        int rollNumber = random.nextInt(1000);

        studentDto.setRollNumber(rollNumber);

        Student student=new Student();

        BeanUtils.copyProperties(studentDto,student);

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(StudentDto studentDto, Integer rollNumber) {

        Optional<Student> student = studentRepository.findByRollNumber(rollNumber);

        if(student.isPresent()){

            Student student1 = student.get();

            student1.setRollNumber(studentDto.getRollNumber());
            student1.setLastname(studentDto.getLastname());
            student1.setCity(studentDto.getCity());
            student1.setState(studentDto.getState());
            student1.setFirstname(studentDto.getFirstname());
            student1.setMobileNumber(studentDto.getMobileNumber());
            student1.setRemark(studentDto.getRemark());

            return studentRepository.save(student1);
        }
        else{
            throw new StudentNotFoundException(AppConstants.STUDENT,AppConstants.ROLLNUMBER,rollNumber);
        }

    }

    @Override
    public void deleteStudent(Integer rollNumber) {

        Optional<Student> student = studentRepository.findByRollNumber(rollNumber);

       if (student.isEmpty()){
           throw new StudentNotFoundException(AppConstants.STUDENT,AppConstants.ROLLNUMBER,rollNumber);
       }
       else{
           studentRepository.delete(student.get());
       }

    }

    @Override
    public List<Student> viewAllStudentDetails() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByState(String state) {

        List<Student> studentList = studentRepository.findAll();

        List<Student> students = studentList.stream().filter(student -> student.getState().equalsIgnoreCase(state)).collect(Collectors.toList());

        if (students.isEmpty()){
            throw new StudentNotFoundException(AppConstants.STUDENT,AppConstants.STATE,state);
        }

        return students;
    }

    @Override
    public List<Student> getStudentByCity(String city) {

        List<Student> studentList = studentRepository.findByCity(city);

        if (studentList.isEmpty()){
            throw new StudentNotFoundException(AppConstants.STUDENT,AppConstants.CITY,city);
        }

        return studentList;
    }

    @Override
    public Student getStudentByRollNumber(Integer rollNumber) {

        Optional<Student> student = studentRepository.findByRollNumber(rollNumber);

        if (student.isPresent()){

            return student.get();
        }
        else{
            throw new StudentNotFoundException(AppConstants.STUDENT,AppConstants.ROLLNUMBER,rollNumber);
        }

    }

    @Override
    public Student getStudentByName(String firstname) {

        List<Student> studentList = studentRepository.findAll();

        Student student1 = studentList.stream().filter(student -> student.getFirstname().equalsIgnoreCase(firstname))
                .findAny().orElseThrow(() -> new StudentNotFoundException(AppConstants.STUDENT, AppConstants.FIRSTNAME, firstname));

        return student1;
    }

    @Override
    public List<Student> getStudentByLastname(String lastname) {

        List<Student> studentList = studentRepository.findAll();

        List<Student> students = studentList.stream().filter(student -> student.getLastname().equalsIgnoreCase(lastname)).collect(Collectors.toList());

        if (students.isEmpty()){
            throw new StudentNotFoundException(AppConstants.STUDENT,AppConstants.LASTNAME,lastname);
        }

        return students;
    }
}
