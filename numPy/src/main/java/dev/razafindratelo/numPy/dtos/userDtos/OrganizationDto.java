package dev.razafindratelo.numPy.dtos.userDtos;

import dev.razafindratelo.numPy.dtos.communityDtos.CommunityDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrganizationDto extends UserDto {
    private String NIF;
    private String STAT;
    private String accreditation;
    private LocalDate creationDate;

    public OrganizationDto(
            String email,
            String password,
            String address,
            String phoneNumber,
            String username,
            List<CommunityDto> communityList,
            List<PostDto> posts,
            long score,
            String nif,
            String stat,
            String accreditation,
            LocalDate creationDate
    ) {
        super(email, password, address, phoneNumber, username, communityList, posts, score);
        this.NIF = nif;
        this.STAT = stat;
        this.accreditation = accreditation;
        this.creationDate = creationDate;
    }
}
