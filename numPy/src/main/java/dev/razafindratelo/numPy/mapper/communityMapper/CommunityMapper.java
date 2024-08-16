package dev.razafindratelo.numPy.mapper.communityMapper;

import dev.razafindratelo.numPy.dtos.communityDtos.CommunityDto;
import dev.razafindratelo.numPy.entity.community.Community;

public class CommunityMapper {
    public static CommunityDto mapToCommunityDto(Community community) {
        return new CommunityDto(
                community.getName(),
                community.getDescription(),
                community.getDomain(),
                community.getCreationDate(),
                community.getMembers()
        );
    }
    public static Community mapToCommunity(CommunityDto community) {
        return new Community(
                community.getName(),
                community.getDescription(),
                community.getDomain(),
                community.getCreationDate(),
                community.getMembers()
        );
    }
}
