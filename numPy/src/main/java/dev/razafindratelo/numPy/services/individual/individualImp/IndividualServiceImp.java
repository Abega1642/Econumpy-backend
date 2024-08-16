package dev.razafindratelo.numPy.services.individual.individualImp;

import dev.razafindratelo.numPy.Exceptions.ResourceDuplicatedException;
import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.repositories.userRepository.UserRepository;
import dev.razafindratelo.numPy.services.individual.IndividualService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@AllArgsConstructor
@Service
public class IndividualServiceImp implements IndividualService {

    UserRepository individualRepository;

    @Override
    public IndividualDto createIndividual(IndividualDto individualDto) {
        if(!checkIndividualUnique(individualDto)){
            throw new ResourceDuplicatedException("this user already exists");
        }
        Individual individual = individualRepository.save(IndividualMapper.toIndividual(individualDto));

        return IndividualMapper.toIndividualDto(individual);
    }

    @Override
    public IndividualDto updateIndividual(String individualId, IndividualDto individualDto) throws Exception {
        Individual individual = (Individual) individualRepository.findById(individualId)
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
        List<Individual> individualList = Collections.singletonList((Individual) individualRepository.findAll());
        for(Individual i : individualList) {
            if (i.getEmail().equals(individualDto.getEmail())) {
                return false;
            }
        }
        return true;
    }
}
