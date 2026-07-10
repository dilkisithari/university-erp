package src.main.java.com.uni.universityERP.repository;

import src.main.java.com.uni.universityERP.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
