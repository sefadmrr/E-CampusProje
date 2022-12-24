package com.eCampus.project.service;

import com.eCampus.project.dto.StaffDto;
import com.eCampus.project.dto.converter.StaffDtoConverter;
import com.eCampus.project.dto.request.CreateStaffRequest;
import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Staff;
import com.eCampus.project.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StaffService {

    private final StaffRepository staffRepository;
    private final StaffDtoConverter staffDtoConverter;

    public StaffService(StaffRepository staffRepository,
                        StaffDtoConverter staffDtoConverter) {
        this.staffRepository = staffRepository;
        this.staffDtoConverter = staffDtoConverter;
    }

    public StaffDto save(CreateStaffRequest request) {
        Staff saved = new Staff(
                request.getName(),
                request.getSurname(),
                request.getMail(),
                request.getNumber(),
                null
        );

        if (!staffRepository.existsStaffByMail(saved.getMail())) {
            return staffDtoConverter.convertStaffToStaffDto(
                    staffRepository.save(saved));
        }

        throw new RuntimeException("");
    }

    public void delete(String mail) {
        staffRepository.deleteById(getStaffByMail(mail).getId());
    }

    public StaffDto getByMail(String mail) {
        return staffDtoConverter.convertStaffToStaffDto(getStaffByMail(mail));
    }

    private Staff getStaffByMail(String mail) {
        return staffRepository.findStaffByMail(mail)
                .orElseThrow(() -> new NotFoundException("staff not found, mail: " + mail));
    }
}
