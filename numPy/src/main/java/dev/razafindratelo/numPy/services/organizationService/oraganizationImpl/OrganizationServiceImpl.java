package dev.razafindratelo.numPy.services.organizationService.oraganizationImpl;

import dev.razafindratelo.numPy.Exceptions.ResourceDuplicatedException;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
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
        List<User> organizations = organizationRepository.findAll();
        for(User i : organizations) {
            if (i.getEmail().equals(organizationDto.getEmail())) {
                throw new ResourceDuplicatedException("this organization is already exist");
            }
        }
        return true;
    }
}
