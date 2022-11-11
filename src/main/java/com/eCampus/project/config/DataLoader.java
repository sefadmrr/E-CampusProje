package com.eCampus.project.config;

import com.eCampus.project.model.Admin;
import com.eCampus.project.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final AdminRepository adminRepository;

    public DataLoader(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //otomatik olarak admin oluştur veri tabanına at.
        Admin admin = new Admin("sefademirer","sefademirer@ogr.bandirma.edu.tr","admin");
        adminRepository.save(admin);
    }
}
