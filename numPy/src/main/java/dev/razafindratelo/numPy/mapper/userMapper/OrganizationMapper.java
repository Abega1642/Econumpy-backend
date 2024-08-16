package dev.razafindratelo.numPy.mapper.userMapper;

import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.mapper.communityMapper.CommunityMapper;
import dev.razafindratelo.numPy.mapper.postMapper.PostMapper;

public class OrganizationMapper {
    public static OrganizationDto toOrganizationDto(Organization organization) {
        return new OrganizationDto(
                organization.getEmail(),
                organization.getPassword(),
                organization.getAddress(),
                organization.getPhoneNumber(),
                organization.getUsername(),
                organization.getCommunities()
                        .stream()
                        .map(CommunityMapper::mapToCommunityDto)
                        .toList(),
                Organization.getPosts()
                        .stream()
                        .map(PostMapper::mapToPostDto)
                        .toList(),
                Organization.getScore(),
                Organization.getBirthDate()
        );
    }
}
