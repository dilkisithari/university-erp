package com.uni.universityERP.controller;

import com.uni.universityERP.model.Attendance;
import com.uni.universityERP.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")   // Allow requests from anywhere (for development)
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public String listAttendance(Model model) {
        model.addAttribute("attendances", attendanceService.getAllAttendance());
        return "attendance/list";
    }

    @GetMapping("/new")
    public String newAttendanceForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "attendance/form";
    }

    @PostMapping
    public String saveAttendance(@ModelAttribute Attendance attendance) {
        attendanceService.saveAttendance(attendance);
        return "redirect:/attendance";
    }
}
