package dev.razafindratelo.numPy.services.individualService;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;

import java.util.List;

public interface IndividualService {
    IndividualDto createIndividual(IndividualDto individualDto);
    IndividualDto updateIndividual(String individualId,IndividualDto individualDto);
    IndividualDto getIndividualById(String individualId);
    List<IndividualDto> getIndividuals();
    void deleteIndividualById(String individualId);
    boolean checkIndividualUnique(IndividualDto individualDto);
}
