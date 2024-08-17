package dev.razafindratelo.numPy.mapper.userMapper.organizationMapper;

import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.communityMapper.CommunityMapper;
import dev.razafindratelo.numPy.mapper.postMapper.PostMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrganizationMapper {
    public static OrganizationDto toOrganizationDto(Organization organization) {
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

    public static Organization toOrganization(OrganizationDto organization) {
        Organization organization1 = new Organization(
                organization.getEmail(),
                organization.getPassword(),
                organization.getAddress(),
                organization.getPhoneNumber(),
                organization.getUsername(),
                organization.getCommunityList()
                        .stream()
                        .map(CommunityMapper::mapToCommunity)
                        .toList(),
                new ArrayList<>(),
                organization.getScore(),
                organization.getNIF(),
                organization.getSTAT(),
                organization.getAccreditation(),
                organization.getCreationDate()
        );

        List<Post> posts = organization.getPosts()
                .stream()
                .map(postDto -> PostMapper.mapToPost(postDto, organization1))
                .toList();
        organization1.setPosts(posts);

        return organization1;
    }
    public static Organization toOrganization2() {
        Organization organization1 = new Organization(
                "john",
                "aaaa",
                "",
                "",
                "",
                new ArrayList<>(),
                new ArrayList<>(),
                0,
                "",
                "",
                "",
                LocalDate.now()
        );
        return organization1;
    }
}
