package com.uni.universityERP.dto;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String courseName;
    private String courseCode;
    private String description;
    private Integer credits;
    private String department;
    private Boolean isActive;
}