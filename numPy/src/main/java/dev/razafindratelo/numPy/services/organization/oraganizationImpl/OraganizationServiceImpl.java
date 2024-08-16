package dev.razafindratelo.numPy.services.organization.oraganizationImpl;

import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.repositories.userRepository.OrganizationRepository;
import dev.razafindratelo.numPy.services.organization.OrganizationService;

import java.util.List;

public class OraganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        return null;
    }

    @Override
    public OrganizationDto updateOrganization(String organizationId, OrganizationDto organizationDto) throws Exception {
        return null;
    }

    @Override
    public OrganizationDto getOrganizationById(String id) {
        return null;
    }

    @Override
    public List<OrganizationDto> getAllOrganization() {
        return List.of();
    }

    @Override
    public void deleteEventById(String organizationId) {

    }
}
