package dev.razafindratelo.numPy.mapper.userMapper.individualMapper;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.mapper.communityMapper.CommunityMapper;
import dev.razafindratelo.numPy.mapper.postMapper.PostMapper;

public class IndividualMapper {
    public static IndividualDto toIndividualDto(Individual individual) {
        return new IndividualDto(
                individual.getEmail(),
                individual.getPassword(),
                individual.getAddress(),
                individual.getPhoneNumber(),
                individual.getUsername(),
                individual.getCommunities()
                        .stream()
                        .map(CommunityMapper::mapToCommunityDto)
                        .toList(),
                individual.getPosts()
                        .stream()
                        .map(PostMapper::mapToPostDto)
                        .toList(),
                individual.getScore(),
                individual.getBirthDate()
        );
    }
}
