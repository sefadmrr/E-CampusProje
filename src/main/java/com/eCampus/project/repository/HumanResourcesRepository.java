package com.eCampus.project.repository;

import com.eCampus.project.model.HumanResources;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HumanResourcesRepository extends JpaRepository<HumanResources,Long> {
    Optional<HumanResources> findHumanResourcesByUsername(String username);
    boolean existsHumanResourcesByMail(String mail);
}
