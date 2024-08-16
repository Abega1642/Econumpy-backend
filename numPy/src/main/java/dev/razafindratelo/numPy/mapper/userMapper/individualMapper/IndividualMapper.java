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

    public static Individual toIndividual(IndividualDto individual) {
        return new Individual(
                individual.getEmail(),
                individual.getPassword(),
                individual.getAddress(),
                individual.getPhoneNumber(),
                individual.getUsername(),
                individual.getCommunityList()
                        .stream()
                        .map(CommunityMapper::mapToCommunity)
                        .toList(),
                individual.getPosts()
                        .stream()
                        .map(PostMapper::mapToPost)
                        .toList(),
                individual.getScore(),
                individual.getBirthDate()
        );
    }
}
