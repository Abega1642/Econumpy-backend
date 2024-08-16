package dev.razafindratelo.numPy.services.individual.individualImp;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.services.individual.IndividualService;

import java.util.List;

public class IndividualServiceImp implements IndividualService {

    IndividualRepository individualRepository;

    @Override
    public IndividualDto createIndividual(IndividualDto individualDto) {

        Individual individual = individualRepository.save(IndividualMapper);

        return null;
    }

    @Override
    public IndividualDto updateIndividual(String individualId, IndividualDto individualDto) throws Exception {
        Individual individual = individualRepository.findById(individualId)
                .orElseThrow(()->
                    new Exception("")
                );
        individual.setUsername(individualDto.getUsername());
        individual.setEmail(individualDto.getEmail());
        individual.setBirthDate(individualDto.getBirthDate());
        individual.setPhoneNumber(individualDto.getPhoneNumber());
        individual.setAddress(individualDto.getAddress());
        individual.setPassword(individualDto.getPassword());

        Individual updateIndividual = individualRepository.save(individual);
        return IndividualMapper.toIndividualDto(updateIndividual);
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
        for(Individual i : individualList) {
            if (i.getEmail().equals(individualDto.getEmail())) {
                return false;
            }
        }
        return true;
    }
}
