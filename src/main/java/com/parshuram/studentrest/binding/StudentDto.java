package com.parshuram.studentrest.binding;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentDto {

    private Integer id;
    private Integer rollNumber;
    @NotEmpty(message = "FirstName is Required..It Should not be Empty")
    private String firstname;
    @NotEmpty(message = "LastName is Required..It Should not be Empty")
    private String lastname;
    @NotEmpty(message = "city should not be an Empty....")
    private String city;
    @NotEmpty(message = "state is Required..")
    private String state;
    @NotEmpty(message = "Mobile Must be In 10 Digit...")
    private String mobileNumber;
    @NotEmpty(message = "Please give a remark..")
    private String remark;



}
