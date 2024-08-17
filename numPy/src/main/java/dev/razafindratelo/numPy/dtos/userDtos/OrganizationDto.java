package dev.razafindratelo.numPy.dtos.userDtos;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
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
            String nif,
            String stat,
            String accreditation,
            LocalDate creationDate
    ) {
        super(email, password, address, phoneNumber, username);
        this.NIF = nif;
        this.STAT = stat;
        this.accreditation = accreditation;
        this.creationDate = creationDate;
    }
}
