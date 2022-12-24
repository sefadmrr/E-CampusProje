package com.eCampus.project.dto.converter;

import com.eCampus.project.dto.HumanResourcesDto;
import com.eCampus.project.model.HumanResources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HumanResourcesDtoConverter {

    public HumanResourcesDto convertHumanResourcesToHumanResourcesDto(HumanResources from) {
        return new HumanResourcesDto(
                from.getUsername(),
                from.getMail(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public List<HumanResourcesDto> convertHumanResourcesListToHumanResourcesDtoList
            (List<HumanResources> from) {

        return from.stream().map(this::convertHumanResourcesToHumanResourcesDto).collect(Collectors.toList());
    }
}
