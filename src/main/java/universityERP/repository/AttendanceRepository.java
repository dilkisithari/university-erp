package universityERP.repository;

import universityERP.model.Attendance;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    long countByAttendanceDateGreaterThanEqualAndAttendanceDateLessThan(
            LocalDateTime start, LocalDateTime end);

    @Query("SELECT COUNT(a) FROM Attendance a WHERE a.attendanceDate >= :start "
            + "AND a.attendanceDate < :end "
            + "AND UPPER(a.status) IN ('PRESENT', 'LATE')")
    long countAttendedBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
