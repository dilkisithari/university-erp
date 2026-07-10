package src.main.java.com.uni.universityERP.controller;
<<<<<<< HEAD

import src.main.java.com.uni.universityERP.model.Exam;
import src.main.java.com.uni.universityERP.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public String listExams(Model model) {
        model.addAttribute("exams", examService.getAllExams());
        return "exams/list";
    }

    @GetMapping("/new")
    public String newExamForm(Model model) {
        model.addAttribute("exam", new Exam());
        return "exams/form";
    }

    @PostMapping
    public String saveExam(@ModelAttribute Exam exam) {
        examService.saveExam(exam);
        return "redirect:/exams";
    }
=======
public class ExamController {

>>>>>>> c8bb31b97e057c658a004bf4b772e798b1ea1c6a
}
