package com.eCampus.project.config;

import com.eCampus.project.model.Admin;
import com.eCampus.project.model.Department;
import com.eCampus.project.model.Faculty;
import com.eCampus.project.model.Student;
import com.eCampus.project.repository.AdminRepository;
import com.eCampus.project.repository.DepartmentRepository;
import com.eCampus.project.repository.FacultyRepository;
import com.eCampus.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${openapi.url}")
    private String openApiUrl;

    public DataLoader(AdminRepository adminRepository,
                      StudentRepository studentRepository,
                      DepartmentRepository departmentRepository,
                      FacultyRepository facultyRepository) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //otomatik olarak admin oluştur veri tabanına at.
        Admin admin = new Admin("sefademirer","sefademirer@ogr.bandirma.edu.tr","admin");
        adminRepository.save(admin);
        Faculty faculty = new Faculty("Muhendislik Fakultesi");
        facultyRepository.save(faculty);
        Department department = new Department("BilgisayarMühendsiliği", faculty);
        departmentRepository.save(department);
        Student student = new Student("Yağız","ergil","18.08.2019",4,department);
        studentRepository.save(student);

        System.out.println("--------------------------------------------");
        System.out.println("Username: " + username + "\n" + "Password: " + password + "\n" +
                "H2 Username: " + dbUsername + "\n" +
                "H2 Password: " + dbPassword + "\n" +
                "Server Port: " + serverPort + "\n" +
                "Openapi Url: " + openApiUrl);
        System.out.println("--------------------------------------------");
    }
}
