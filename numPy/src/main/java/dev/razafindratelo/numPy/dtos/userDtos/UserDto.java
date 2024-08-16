package dev.razafindratelo.numPy.dtos.userDtos;

import dev.razafindratelo.numPy.dtos.communityDtos.CommunityDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    protected String email;
    protected String password;
    protected String address;
    protected String phoneNumber;
    protected String username;
    protected List<CommunityDto> communityList;
    protected List<PostDto> posts;
    protected long score;
}
