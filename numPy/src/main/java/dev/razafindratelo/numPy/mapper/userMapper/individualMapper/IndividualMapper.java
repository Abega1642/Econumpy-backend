package dev.razafindratelo.numPy.mapper.userMapper.individualMapper;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.mapper.communityMapper.CommunityMapper;
import dev.razafindratelo.numPy.mapper.postMapper.PostMapper;

import java.util.ArrayList;
import java.util.List;

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

    public static Individual toIndividual(IndividualDto individualDto) {
        Individual individual = new Individual(
                individualDto.getEmail(),
                individualDto.getPassword(),
                individualDto.getAddress(),
                individualDto.getPhoneNumber(),
                individualDto.getUsername(),
                individualDto.getCommunityList()
                        .stream()
                        .map(CommunityMapper::mapToCommunity)
                        .toList(),
                new ArrayList<>(),
                individualDto.getScore(),
                individualDto.getBirthDate()
        );
        List<Post> posts = individualDto.getPosts()
                .stream()
                .map(postDto -> PostMapper.mapToPost(postDto, individual))
                .toList();
        individual.setPosts(posts);

        return individual;
    }


}
