package com.uni.universityERP.controller;

import com.uni.universityERP.model.Exam;
import com.uni.universityERP.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")   // Allow requests from anywhere (for development)
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
}
