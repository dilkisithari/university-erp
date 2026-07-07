package src.main.java.com.uni.universityERP.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    private String courseCode;

    @Column(length = 500)
    private String description;

    private Integer credits = 3;

    private String department;

    private LocalDate startDate;
    private LocalDate endDate;

    private Boolean isActive = true;
}
