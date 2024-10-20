package com.simpleproejct.school_management.model;

import lombok.Data;

@Data// it adds getters and setters internally we do not need to write it manually
public class Student {

    private int studentId;
    private String name;
    private String dob;
    private String gender;
    private String grade;
}
