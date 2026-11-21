package universityERP.controller;

import universityERP.model.Attendance;
import universityERP.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(
            AttendanceService attendanceService) {

        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @PostMapping
    public Attendance saveAttendance(
            @RequestBody Attendance attendance) {

        return attendanceService.saveAttendance(attendance);
    }

    @GetMapping("/test")
    public String test() {
        return "Attendance API Working";
    }
}