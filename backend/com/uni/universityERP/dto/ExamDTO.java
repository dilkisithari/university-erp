package com.uni.universityERP.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExamDTO {

    private Long id;
    private Long courseId;
    private String courseName;
    private String examType;        // MIDTERM, FINAL, QUIZ, ASSIGNMENT
    private LocalDateTime examDate;
    private String location;
    private Integer totalMarks;
    private String description;
    private Boolean isActive = true;
}
