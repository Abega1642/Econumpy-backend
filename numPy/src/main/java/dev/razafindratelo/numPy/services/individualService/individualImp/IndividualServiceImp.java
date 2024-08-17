package dev.razafindratelo.numPy.services.individualService.individualImp;

import dev.razafindratelo.numPy.Exceptions.ResourceDuplicatedException;
import dev.razafindratelo.numPy.Exceptions.ResourceNotFoundException;
import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.Login;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.repositories.userRepository.UserRepository;
import dev.razafindratelo.numPy.services.individualService.IndividualService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@AllArgsConstructor
@Service
public class IndividualServiceImp implements IndividualService {
    private UserRepository individualRepository;


    @Override
    public IndividualDto createIndividual(IndividualDto individualDto) {
        if(!checkIndividualUnique(individualDto)){
            throw new ResourceDuplicatedException("this user already exists");
        }
        System.out.println(individualDto.toString());
        Individual individual = individualRepository.save(IndividualMapper.toIndividual(individualDto));

        return IndividualMapper.toIndividualDto(individual);
    }

    @Override
    public IndividualDto updateIndividual(String individualId, IndividualDto individualDto) {
        Individual individual = (Individual) individualRepository.findById(individualId)
                .orElseThrow(()->
                    new ResourceNotFoundException("Individual with id " + individualId + " not found")
                );
        System.out.println(individual.getAddress() + " " + individual.getUsername() + " " + individual.getEmail());
        individual.setUsername(individualDto.getUsername());
        individual.setEmail(individualDto.getEmail());
        individual.setBirthDate(individualDto.getBirthDate());
        individual.setPhoneNumber(individualDto.getPhoneNumber());
        individual.setAddress(individualDto.getAddress());
        individual.setPassword(individualDto.getPassword());
        individual.setScore(individualDto.getScore());

        Individual updateIndividual = individualRepository.save(individual);
        return IndividualMapper.toIndividualDto(updateIndividual);
    }

    @Override
    public IndividualDto getIndividualById(String individualId) {
        User user =individualRepository.findById(individualId)
                .orElse(null);
        if(user == null || user instanceof Organization){
//            throw new ResourceNotFoundException("Individual with id " + individualId + " not found");
            return null;
        } else if (user instanceof Individual){
            Individual individual = (Individual) user;
            return IndividualMapper.toIndividualDto(individual);
        }
        return null;
    }

    @Override
    public List<IndividualDto> getIndividuals() {
        List<User> users = individualRepository.findAll();

        List<Individual> individualList = new ArrayList<>();

        for (User user : users) {
            if (user instanceof Individual) {
                individualList.add((Individual) user);
            }
        }

        return individualList.stream()
                .map(IndividualMapper::toIndividualDto)
                .toList();
    }

    @Override
    public void deleteIndividualById(String individualId) {
        individualRepository.deleteById(individualId);
    }

    @Override
    public boolean checkIndividualUnique(IndividualDto individualDto) {
      List<User> users = individualRepository.findAll();

        List<Individual> individualList = new ArrayList<>();

        for (User user : users) {
            if (user instanceof Individual) {
                individualList.add((Individual) user);
            }
        }
        for (Individual individual : individualList) {
            if(individual.getEmail().equals(individualDto.getEmail())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean loginUser(Login login) {
        List<User> users = individualRepository.findAll();
        List<Individual> individualList = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Individual) {
                individualList.add((Individual) user);
            }
        }
        for (Individual individual : individualList) {
            if(individual.getEmail().equals(login.email())
            && individual.getPassword().equals(login.password())) {
                return true;
            }
        }
        return false;
    }

}


