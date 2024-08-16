package dev.razafindratelo.numPy.mapper.userMapper.organizationMapper;

import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
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
                organization.getPosts()
                        .stream()
                        .map(PostMapper::mapToPostDto)
                        .toList(),
                organization.getScore(),
                organization.getNIF(),
                organization.getSTAT(),
                organization.getAccreditation(),
                organization.getCreationDate()
        );
    }

    public static Organization toOrganization(OrganizationDto organization) {
        return new Organization(
                organization.getEmail(),
                organization.getPassword(),
                organization.getAddress(),
                organization.getPhoneNumber(),
                organization.getUsername(),
                organization.getCommunityList()
                        .stream()
                        .map(CommunityMapper::mapToCommunity)
                        .toList(),
                organization.getPosts()
                        .stream()
                        .map(PostMapper::mapToPost)
                        .toList(),
                organization.getScore(),
                organization.getNIF(),
                organization.getSTAT(),
                organization.getAccreditation(),
                organization.getCreationDate()
        );
    }
}
