package dev.razafindratelo.numPy.services.organization.oraganizationImpl;

import dev.razafindratelo.numPy.Exceptions.ResourceDuplicatedException;
import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.mapper.userMapper.organizationMapper.OrganizationMapper;
import dev.razafindratelo.numPy.repositories.userRepository.OrganizationRepository;
import dev.razafindratelo.numPy.repositories.userRepository.UserRepository;
import dev.razafindratelo.numPy.services.organization.OrganizationService;

import java.util.List;

public class OraganizationServiceImpl implements OrganizationService {

    private UserRepository organizationRepository;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        if(!checkOrganizationUnique(organizationDto)){
            throw new ResourceDuplicatedException("this organization is already exist");
        }
        Organization organization = organizationRepository.save(OrganizationMapper.toOrganization(organizationDto));

        return OrganizationMapper.toOrganizationDto(organization);
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

    public boolean checkOrganizationUnique(OrganizationDto organizationDto) {
        List<Organization> organizations = organizationRepository.findAll();
        for(Organization i : organizations) {
            if (i.getEmail().equals(organizationDto.getEmail())) {
                return false;
            }
        }
        return true;
    }
}
