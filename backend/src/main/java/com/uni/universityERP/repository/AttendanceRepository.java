package src.main.java.com.uni.universityERP.repository;

import src.main.java.com.uni.universityERP.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
