package dev.razafindratelo.numPy.services.organizationService.oraganizationImpl;

import dev.razafindratelo.numPy.Exceptions.ResourceDuplicatedException;
import dev.razafindratelo.numPy.Exceptions.ResourceNotFoundException;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.mapper.userMapper.organizationMapper.OrganizationMapper;
import dev.razafindratelo.numPy.repositories.userRepository.UserRepository;
import dev.razafindratelo.numPy.services.organizationService.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private static UserRepository organizationRepository;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        if(!checkOrganizationUnique(organizationDto)){
            throw new ResourceDuplicatedException("this organization is already exist");
        }
        Organization organization = organizationRepository.save(OrganizationMapper.toOrganization(organizationDto));

        return OrganizationMapper.toOrganizationDto(organization);
    }

    @Override
    public OrganizationDto updateOrganization(String organizationId, OrganizationDto organizationDto) throws Exception {
        Organization organization = (Organization) organizationRepository.findById(organizationId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Individual with id " + organizationId + " not found")
                );
        organization.setNIF(organizationDto.getNIF());
        organization.setSTAT(organizationDto.getSTAT());
        organization.setAddress(organizationDto.getAddress());
        organization.setPassword(organizationDto.getPassword());
        organization.setEmail(organizationDto.getEmail());

        Organization updatedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.toOrganizationDto(updatedOrganization);

    }

    @Override
    public OrganizationDto getOrganizationById(String id) {
        Organization organization = (Organization) organizationRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Individual with " + id + " not found")
        );
        return OrganizationMapper.toOrganizationDto(organization);
    }

    @Override
    public List<OrganizationDto> getAllOrganization() {
        List<Organization> organizationList = organizationRepository.findAll().stream().map(user -> (Organization)user).toList();
        return organizationList.stream()
                .map(OrganizationMapper::toOrganizationDto)
                .toList();
    }

    @Override
    public void deleteEventById(String organizationId) {

    }

    public boolean checkOrganizationUnique(OrganizationDto organizationDto) {
        List<Organization> organizations = organizationRepository.findAll().stream().map(user -> (Organization) user).toList();
        for(Organization i : organizations) {
            if (i.getEmail().equals(organizationDto.getEmail())) {
                throw new ResourceDuplicatedException("this organization is already exist");
            }
        }
        return true;
    }
}
