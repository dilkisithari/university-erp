package com.uni.universityERP.service;

import com.uni.universityERP.dto.DashboardSummaryResponse;
import com.uni.universityERP.repository.AttendanceRepository;
import com.uni.universityERP.repository.CourseRepository;
import com.uni.universityERP.repository.ExamRepository;
import com.uni.universityERP.repository.StudentRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ExamRepository examRepository;
    private final AttendanceRepository attendanceRepository;

    public DashboardService(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            ExamRepository examRepository,
            AttendanceRepository attendanceRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
        this.attendanceRepository = attendanceRepository;
    }

    public DashboardSummaryResponse getSummary() {
        long totalStudents = studentRepository.count();
        long totalCourses = courseRepository.count();
        long examsScheduled =
                examRepository.countByIsActiveTrueAndExamDateGreaterThanEqual(LocalDateTime.now());
        double attendanceRate = calculateTodayAttendanceRate();

        return new DashboardSummaryResponse(
                totalStudents, totalCourses, examsScheduled, attendanceRate);
    }

    private double calculateTodayAttendanceRate() {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        long totalToday =
                attendanceRepository.countByAttendanceDateGreaterThanEqualAndAttendanceDateLessThan(
                        start, end);
        if (totalToday == 0L) {
            return 0.0;
        }

        long attended = attendanceRepository.countAttendedBetween(start, end);
        double rate = (attended * 100.0) / totalToday;
        if (Double.isNaN(rate) || Double.isInfinite(rate)) {
            return 0.0;
        }

        return BigDecimal.valueOf(rate).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
