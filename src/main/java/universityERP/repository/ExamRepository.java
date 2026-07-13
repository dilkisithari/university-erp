package universityERP.repository;

import universityERP.model.Exam;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    long countByIsActiveTrueAndExamDateGreaterThanEqual(LocalDateTime dateTime);
}