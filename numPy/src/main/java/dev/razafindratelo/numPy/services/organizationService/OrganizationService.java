package dev.razafindratelo.numPy.services.organizationService;


import dev.razafindratelo.numPy.dtos.userDtos.Login;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;

import java.util.List;

public interface OrganizationService {

        OrganizationDto createOrganization(OrganizationDto organizationDto);
        OrganizationDto updateOrganization(String organizationId,OrganizationDto organizationDto);
        OrganizationDto getOrganizationById(String id);
        List<OrganizationDto> getAllOrganization();
        void deleteEventById(String organizationId);
        boolean checkOrganizationUnique(OrganizationDto organizationDto);
        boolean loginUser(Login login);

}
