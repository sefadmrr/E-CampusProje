package com.eCampus.project.repository;

import com.eCampus.project.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
