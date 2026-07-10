package src.main.java.com.uni.universityERP.service;

import src.main.java.com.uni.universityERP.model.Exam;
import src.main.java.com.uni.universityERP.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

<<<<<<< HEAD
    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Optional<Exam> getExamById(Long id) {
        return examRepository.findById(id);
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
=======
>>>>>>> c8bb31b97e057c658a004bf4b772e798b1ea1c6a
}
