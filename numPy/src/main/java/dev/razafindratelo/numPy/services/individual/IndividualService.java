package dev.razafindratelo.numPy.services.individual;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;

import java.util.List;

public interface IndividualService {
    IndividualDto createIndividual(IndividualDto individualDto);
    IndividualDto updateIndividual(String individualId,IndividualDto individualDto);
    IndividualDto getEventById(String id);
    List<IndividualDto> getAllIndividual();
    void deleteEventById(String individualId);
}
