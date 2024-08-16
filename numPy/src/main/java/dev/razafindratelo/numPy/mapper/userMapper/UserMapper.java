package dev.razafindratelo.numPy.mapper.userMapper;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.communityMapper.CommunityMapper;
import dev.razafindratelo.numPy.mapper.postMapper.PostMapper;

public class UserMapper {

    // Map a User entity to the correct UserDto subclass
    public static UserDto mapUserToUserDto(User user) {
        if (user instanceof Individual) {
            Individual individual = (Individual) user;
            return new IndividualDto(
                    individual.getEmail(),
                    individual.getPassword(),
                    individual.getAddress(),
                    individual.getPhoneNumber(),
                    individual.getUsername(),
                    individual.getCommunities().stream().map(CommunityMapper::mapToCommunityDto).toList(),
                    individual.getPosts().stream().map(PostMapper::mapToPostDto).toList(),
                    individual.getScore(),
                    individual.getBirthDate()  // Specific to Individual
            );
        } else if (user instanceof Organization) {
            Organization organization = (Organization) user;
            return new OrganizationDto(
                    organization.getEmail(),
                    organization.getPassword(),
                    organization.getAddress(),
                    organization.getPhoneNumber(),
                    organization.getUsername(),
                    organization.getCommunities().stream().map(CommunityMapper::mapToCommunityDto).toList(),
                    organization.getPosts().stream().map(PostMapper::mapToPostDto).toList(),
                    organization.getScore(),
                    organization.getNIF(),  // Specific to Organization
                    organization.getSTAT(),
                    organization.getAccreditation(),
                    organization.getCreationDate()
            );
        }

        // Handle other user types or throw an exception if the user type is unknown
        throw new IllegalArgumentException("Unknown user type: " + user.getClass().getSimpleName());
    }

    // Map a UserDto to the correct User subclass
    public static User mapUserToUser(UserDto userDto) {
        if (userDto instanceof IndividualDto) {
            IndividualDto individualDto = (IndividualDto) userDto;
            return new Individual(
                    individualDto.getEmail(),
                    individualDto.getPassword(),
                    individualDto.getAddress(),
                    individualDto.getPhoneNumber(),
                    individualDto.getUsername(),
                    individualDto.getCommunityList().stream().map(CommunityMapper::mapToCommunity).toList(),
                    individualDto.getPosts().stream().map(PostMapper::mapToPost).toList(),
                    individualDto.getScore(),
                    individualDto.getBirthDate()  // Specific to Individual
            );
        } else if (userDto instanceof OrganizationDto) {
            OrganizationDto organizationDto = (OrganizationDto) userDto;
            return new Organization(
                    organizationDto.getEmail(),
                    organizationDto.getPassword(),
                    organizationDto.getAddress(),
                    organizationDto.getPhoneNumber(),
                    organizationDto.getUsername(),
                    organizationDto.getCommunityList().stream().map(CommunityMapper::mapToCommunity).toList(),
                    organizationDto.getPosts().stream().map(PostMapper::mapToPost).toList(),
                    organizationDto.getScore(),
                    organizationDto.getNIF(),  // Specific to Organization
                    organizationDto.getSTAT(),
                    organizationDto.getAccreditation(),
                    organizationDto.getCreationDate()
            );
        }

        // Handle other cases or throw an exception if the user type is unknown
        throw new IllegalArgumentException("Unknown userDto type: " + userDto.getClass().getSimpleName());
    }
}
