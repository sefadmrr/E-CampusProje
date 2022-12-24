package com.eCampus.project.repository;

import com.eCampus.project.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff,Long> {
    Optional<Staff> findStaffByMail(String mail);
    boolean existsStaffByMail(String mail);
}
