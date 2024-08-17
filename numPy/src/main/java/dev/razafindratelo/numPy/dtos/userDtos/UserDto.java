package dev.razafindratelo.numPy.dtos.userDtos;

import dev.razafindratelo.numPy.dtos.communityDtos.CommunityDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {
    protected String email;
    protected String password;
    protected String address;
    protected String phoneNumber;
    protected String username;
    protected List<CommunityDto> communityList;
    protected List<PostDto> posts;
    protected long score;

    public UserDto(String email, String password, String address, String phoneNumber, String username) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.communityList = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.score = 0;
    }
}
