package com.eCampus.project.repository;

import com.eCampus.project.model.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonsRepository extends JpaRepository<Lessons,Long> {
    Optional<Lessons> findLessonsByLessonName(String lessonsName);
}
