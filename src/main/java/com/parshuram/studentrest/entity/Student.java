package com.parshuram.studentrest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student_details")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "roll_number")
    private Integer rollNumber;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "remark")
    private String remark;

    public Student(){

    }

    public Student(Integer id, Integer rollNumber, String firstname, String lastname, String city, String state, String mobileNumber,String remark) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.state = state;
        this.mobileNumber = mobileNumber;
        this.remark=remark;
    }

}
