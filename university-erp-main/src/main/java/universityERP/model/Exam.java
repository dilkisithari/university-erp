package universityERP.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "exams")
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examCode;

    private String courseName;

    private String examType;

    private Integer maxMarks;

    private LocalDate examDate;

    private Integer duration;

    private String venue;

    private String status;
}