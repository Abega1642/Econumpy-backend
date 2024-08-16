package dev.razafindratelo.numPy.mapper.userMapper;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.communityMapper.CommunityMapper;
import dev.razafindratelo.numPy.mapper.postMapper.PostMapper;

public class UserMapper {
    public static UserDto MapUserToUserDto(User user) {
        return new UserDto(
                user.getEmail(),
                user.getPassword(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getUsername(),
                user.getCommunities().stream().map(community -> CommunityMapper.mapToCommunityDto(community)).toList(),
                user.getPosts().stream().map(post -> PostMapper.mapToPostDto(post)).toList(),
                user.getScore()
        );
    }
    public static User MapUserToUser(UserDto user) {
        return new User(
                user.getEmail(),
                user.getPassword(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getUsername(),
                user.getCommunityList().stream().map(CommunityMapper::mapToCommunity).toList(),
                user.getPosts().stream().map(PostMapper::mapToPost).toList(),
                user.getScore()
        );
    }

}
