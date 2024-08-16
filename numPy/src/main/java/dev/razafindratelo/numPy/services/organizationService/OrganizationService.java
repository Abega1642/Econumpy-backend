package dev.razafindratelo.numPy.services.organizationService;


import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;

import java.util.List;

public interface OrganizationService {

        OrganizationDto createOrganization(OrganizationDto organizationDto);
        OrganizationDto updateOrganization(String organizationId,OrganizationDto organizationDto) throws Exception;
        OrganizationDto getOrganizationById(String id);
        List<OrganizationDto> getAllOrganization();
        void deleteEventById(String organizationId);

}
