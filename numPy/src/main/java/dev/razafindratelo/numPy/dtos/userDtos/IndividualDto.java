package dev.razafindratelo.numPy.dtos.userDtos;

import dev.razafindratelo.numPy.dtos.communityDtos.CommunityDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class IndividualDto extends UserDto {
    private LocalDate birthDate;

    public IndividualDto(
            String email,
            String password,
            String address,
            String phoneNumber,
            String username,
            List<CommunityDto> communityList,
            List<PostDto> posts,
            long score,
            LocalDate birthDate
    ) {
        super(email, password, address, phoneNumber, username, score);
        this.birthDate = birthDate;
    }
}
