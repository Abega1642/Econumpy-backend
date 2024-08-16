package dev.razafindratelo.numPy.services.userServices;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.UserDto;

import java.util.List;

public interface IndividualService {
    IndividualDto createIndividual(IndividualDto individualDto);
    IndividualDto updateIndividual(String individualId,IndividualDto individualDto);
    IndividualDto getIndividualById(String individualId);
    List<IndividualDto> getIndividuals();
    void deleteIndividualById(String individualId);
    boolean checkUserLogin(IndividualDto individualDto);
}
