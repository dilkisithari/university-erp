package universityERP.service;

import universityERP.dto.DashboardSummaryResponse;
import universityERP.repository.AttendanceRepository;
import universityERP.repository.CourseRepository;
import universityERP.repository.ExamRepository;
import universityERP.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
                examRepository.count();

        double attendanceRate =
                calculateAttendanceRate();

        return new DashboardSummaryResponse(
                totalStudents,
                totalCourses,
                examsScheduled,
                attendanceRate
        );
    }

    private double calculateAttendanceRate() {

        long total =
                attendanceRepository.count();

        if (total == 0) {
            return 0.0;
        }

        long present =
                attendanceRepository.findAll()
                        .stream()
                        .filter(a ->
                                "Present".equalsIgnoreCase(
                                        a.getStatus()))
                        .count();

        return BigDecimal.valueOf(
                        (present * 100.0) / total)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }
}