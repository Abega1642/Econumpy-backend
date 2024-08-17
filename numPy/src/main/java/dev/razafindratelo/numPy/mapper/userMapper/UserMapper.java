package dev.razafindratelo.numPy.mapper.userMapper;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.communityMapper.CommunityMapper;
import dev.razafindratelo.numPy.mapper.postMapper.PostMapper;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto mapUserToUserDto(User user) {
        if (user instanceof Individual) {
            Individual individual = (Individual) user;
            return new IndividualDto(
                    individual.getEmail(),
                    individual.getPassword(),
                    individual.getAddress(),
                    individual.getPhoneNumber(),
                    individual.getUsername(),
                    individual.getBirthDate()
            );
        } else if (user instanceof Organization) {
            Organization organization = (Organization) user;
            return new OrganizationDto(
                    organization.getEmail(),
                    organization.getPassword(),
                    organization.getAddress(),
                    organization.getPhoneNumber(),
                    organization.getUsername(),
                    organization.getNIF(),
                    organization.getSTAT(),
                    organization.getAccreditation(),
                    organization.getCreationDate()
            );
        }
        throw new IllegalArgumentException("Unknown user type: " + user.getClass().getSimpleName());
    }

    public static User mapUserToUser(UserDto userDto) {
        if (userDto instanceof IndividualDto) {
            IndividualDto individualDto = (IndividualDto) userDto;
            Individual individual = new Individual(
                    individualDto.getEmail(),
                    individualDto.getPassword(),
                    individualDto.getAddress(),
                    individualDto.getPhoneNumber(),
                    individualDto.getUsername(),
                    individualDto.getCommunityList().stream().map(CommunityMapper::mapToCommunity).toList(),
                    new ArrayList<>(),
                    individualDto.getScore(),
                    individualDto.getBirthDate()
            );
            List<Post> posts = userDto.getPosts()
                    .stream()
                    .map(postDto -> PostMapper.mapToPost(postDto, UserMapper.mapUserToUser(userDto)))
                    .toList();
            individual.setPosts(posts);
            return individual;

        } else if (userDto instanceof OrganizationDto) {
            OrganizationDto organizationDto = (OrganizationDto) userDto;
            Organization organization = new Organization(
                    organizationDto.getEmail(),
                    organizationDto.getPassword(),
                    organizationDto.getAddress(),
                    organizationDto.getPhoneNumber(),
                    organizationDto.getUsername(),
                    organizationDto.getCommunityList().stream().map(CommunityMapper::mapToCommunity).toList(),
                    new ArrayList<>(),
                    organizationDto.getScore(),
                    organizationDto.getNIF(),
                    organizationDto.getSTAT(),
                    organizationDto.getAccreditation(),
                    organizationDto.getCreationDate()
            );
            List<Post> posts = userDto.getPosts()
                    .stream()
                    .map(postDto -> PostMapper.mapToPost(postDto, UserMapper.mapUserToUser(userDto)))
                    .toList();
            organization.setPosts(posts);

            return organization;
        }
        throw new IllegalArgumentException("Unknown userDto type: " + userDto.getClass().getSimpleName());
    }
}
