package com.eCampus.project.repository;

import com.eCampus.project.model.StudentAffairs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAffairsRepository extends JpaRepository<StudentAffairs,Long> {
}
