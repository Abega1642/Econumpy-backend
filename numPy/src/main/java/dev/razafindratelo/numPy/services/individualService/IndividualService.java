package dev.razafindratelo.numPy.services.individualService;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.Login;

import java.util.List;

public interface IndividualService {
    IndividualDto createIndividual(IndividualDto individualDto);
    IndividualDto updateIndividual(String individualId,IndividualDto individualDto);
    IndividualDto getIndividualById(String individualId);
    List<IndividualDto> getIndividuals();
    void deleteIndividualById(String individualId);
    boolean checkIndividualUnique(IndividualDto individualDto);
    boolean loginUser(Login login);
}
