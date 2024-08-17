package dev.razafindratelo.numPy.services.organizationService.oraganizationImpl;

import dev.razafindratelo.numPy.Exceptions.ResourceDuplicatedException;
import dev.razafindratelo.numPy.Exceptions.ResourceNotFoundException;
import dev.razafindratelo.numPy.dtos.userDtos.Login;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.mapper.userMapper.organizationMapper.OrganizationMapper;
import dev.razafindratelo.numPy.repositories.userRepository.UserRepository;
import dev.razafindratelo.numPy.services.organizationService.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private UserRepository organizationRepository;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        if(!checkOrganizationUnique(organizationDto)){
            throw new ResourceDuplicatedException("this organization is already exist");
        }
        Organization organization = organizationRepository.save(OrganizationMapper.toOrganization(organizationDto));

        return OrganizationMapper.toOrganizationDto(organization);
    }

    @Override
    public OrganizationDto updateOrganization(String organizationId, OrganizationDto organizationDto) {
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
        User user = organizationRepository.findById(id)
                .orElse(null);
        if(user == null || user instanceof Individual){
//            throw new ResourceNotFoundException("Individual with id " + id + " not found");
            return null;
        } else if (user instanceof Organization){
            Organization organization = (Organization) user;
            return OrganizationMapper.toOrganizationDto(organization);
        }
        return null;
    }

    @Override
    public List<OrganizationDto> getAllOrganization() {
        List<User> users = organizationRepository.findAll();

        List<Organization> organizations = new ArrayList<>();

        for (User user : users) {
            if (user instanceof Organization) {
                organizations.add((Organization) user);
            }
        }
        return organizations.stream()
                .map(OrganizationMapper::toOrganizationDto)
                .toList();
    }

    @Override
    public void deleteEventById(String organizationId) {

    }

    @Override
    public boolean loginUser(Login login) {
        List<User> users = organizationRepository.findAll();

        List<Organization> organization = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Individual) {
                organization.add((Organization) user);
            }
        }
        for (Organization org : organization) {
            if(org.getEmail().equals(login.email())
                    && org.getPassword().equals(login.password())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean checkOrganizationUnique(OrganizationDto organizationDto) {
        List<User> users = organizationRepository.findAll();

        List<Organization> organizationList = new ArrayList<>();

        for (User user : users) {
            if (user instanceof Organization) {
                organizationList.add((Organization) user);
            }
        }
        for (Organization organization : organizationList) {
            if(organization.getEmail().equals(organizationDto.getEmail())) {
                return false;
            }
        }
        return true;
    }
}
