package com.parshuram.studentrest.exception;

import lombok.Data;

@Data
public class StudentNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Integer fieldValue;
    private String name;

    public StudentNotFoundException(String resourceName,String fieldName,Integer fieldValue){
        super(String.format("%s is not Found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }

    public StudentNotFoundException(String resourceName,String fieldName,String name){
        super(String.format("%s is not Found with %s : %s",resourceName,fieldName,name));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.name=name;
    }




}
