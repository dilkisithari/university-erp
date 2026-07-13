package universityERP.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AttendanceDTO {

    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDateTime attendanceDate;
    private String status;  // PRESENT, ABSENT, LATE
    private String remarks;
}