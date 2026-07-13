package universityERP.controller;

import universityERP.model.Exam;
import universityERP.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @PostMapping
    public Exam saveExam(@RequestBody Exam exam) {
        return examService.saveExam(exam);
    }
}