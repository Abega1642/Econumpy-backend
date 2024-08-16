package dev.razafindratelo.numPy.services.individual.individualImp;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.repositories.userRepository.IndividualRepository;
import dev.razafindratelo.numPy.services.individual.IndividualService;

import java.util.List;

public class IndividualServiceImp implements IndividualService {

    IndividualRepository individualRepository;

    @Override
    public IndividualDto createIndividual(IndividualDto individualDto) {
        Individual individual = individualRepository.save(individualDto);

        return null;
    }

    @Override
    public IndividualDto updateIndividual(String individualId, IndividualDto individualDto) {
        return null;
    }

    @Override
    public IndividualDto getEventById(String id) {
        return null;
    }

    @Override
    public List<IndividualDto> getAllIndividual() {
        return List.of();
    }

    @Override
    public void deleteEventById(String individualId) {

    }

    private boolean checkIndividualUnique(IndividualDto individualDto) {
        List<Individual> individualList = individualRepository.findAll();
        for(Individual u : individualList) {
            if (u.getEmail().equals(individualDto)) {
                return false;
            }
        }
        return true;
    }
}
