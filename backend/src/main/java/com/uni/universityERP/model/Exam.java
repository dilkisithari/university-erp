package src.main.java.com.uni.universityERP.model;
<<<<<<< HEAD

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private String examName;  // Midterm, Final, Quiz etc.

    @Column(nullable = false)
    private LocalDateTime examDate;

    private Integer durationMinutes = 120;

    private String venue;

    private Double totalMarks = 100.0;

    private Boolean isActive = true;
=======
public class Exam {

>>>>>>> c8bb31b97e057c658a004bf4b772e798b1ea1c6a
}
