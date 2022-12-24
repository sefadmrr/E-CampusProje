package com.eCampus.project.service;

import com.eCampus.project.dto.HumanResourcesDto;
import com.eCampus.project.dto.converter.HumanResourcesDtoConverter;
import com.eCampus.project.dto.request.CreateHumanResourcesRequest;
import com.eCampus.project.exception.generic.ExistException;
import com.eCampus.project.exception.generic.NoAuthException;
import com.eCampus.project.exception.generic.NotFoundException;
import com.eCampus.project.model.Admin;
import com.eCampus.project.model.HumanResources;
import com.eCampus.project.repository.HumanResourcesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class HumanResourcesService {

    private final HumanResourcesRepository humanResourcesRepository;
    private final HumanResourcesDtoConverter humanResourcesDtoConverter;
    private final AdminService adminService;

    public HumanResourcesService(HumanResourcesRepository humanResourcesRepository,
                                 HumanResourcesDtoConverter humanResourcesDtoConverter,
                                 AdminService adminService) {
        this.humanResourcesRepository = humanResourcesRepository;
        this.humanResourcesDtoConverter = humanResourcesDtoConverter;
        this.adminService = adminService;
    }

    public HumanResourcesDto save(CreateHumanResourcesRequest request) {
        Admin admin = adminService.getAdminByUsername(request.getAdminUsername());

        HumanResources saved = new HumanResources(
                request.getUsername(),
                request.getMail(),
                request.getPassword()
        );

        if (humanResourcesRepository.existsHumanResourcesByMail(saved.getMail())) {
           throw new ExistException("human resources exist!, mail: " + saved.getMail());
        }

        if (Objects.isNull(admin)) {
            throw new NoAuthException("no auth");
        }

        return humanResourcesDtoConverter.convertHumanResourcesToHumanResourcesDto
                (humanResourcesRepository.save(saved));
    }

    public HumanResourcesDto getByUsername(String username) {
        return humanResourcesDtoConverter.convertHumanResourcesToHumanResourcesDto(
                getHumanResourcesByUsername(username));
    }

    public void delete(String username) {
        log.info("human resources deleted: " + username);
        humanResourcesRepository.deleteById(getHumanResourcesByUsername(username).getId());
    }

    private HumanResources getHumanResourcesByUsername(String username) {
        return humanResourcesRepository.findHumanResourcesByUsername(username)
                .orElseThrow(() -> new NotFoundException("humanResources not found, username: " + username));
    }

}
