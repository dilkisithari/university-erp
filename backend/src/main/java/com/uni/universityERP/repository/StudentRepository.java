package com.uni.universityERP.repository;

import com.uni.universityERP.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
