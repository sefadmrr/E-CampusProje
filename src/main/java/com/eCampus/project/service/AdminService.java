package com.eCampus.project.service;

import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Admin;
import com.eCampus.project.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    protected Admin getAdminByUsername(String username) {
        return adminRepository.findAdminByUsername(username)
                .orElseThrow(() -> new NotFoundException("admin not found, username: " + username));
    }
}
