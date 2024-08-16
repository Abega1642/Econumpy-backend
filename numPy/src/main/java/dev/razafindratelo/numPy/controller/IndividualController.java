package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.services.userServices.IndividualService;
import dev.razafindratelo.numPy.services.userServices.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class IndividualController {

    private IndividualService individualService;

    @GetMapping("/individual")
    public ResponseEntity<List<IndividualDto>> getIndividuals() {
        List<IndividualDto> individualDtos = individualService.getIndividuals();
        return ResponseEntity.ok(individualDtos);
    }

    @GetMapping("/individual/{individualId}")
    public ResponseEntity<IndividualDto> getUser(@PathVariable String individualId) {
        IndividualDto individualDto = individualService.getIndividualById(individualId);
        return ResponseEntity.ok(individualDto);
    }

    @PostMapping("/individual/authentication")
    public ResponseEntity<Boolean> loginUser(@RequestBody IndividualDto individualDto) {
        Boolean check = individualService.checkUserLogin(individualDto);
        return (check) ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/individual/add")
    public ResponseEntity<IndividualDto> createUser(@RequestBody IndividualDto individualDto) {
        IndividualDto addUser = individualService.createIndividual(individualDto);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/individual/update/{individualId}")
    public ResponseEntity<IndividualDto> updateUser(@PathVariable("individualId") String individualId, @RequestBody IndividualDto individualDto) {
        IndividualDto updateUser = individualService.updateIndividual(individualId, individualDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/individual/delete/{id}")
    public String deleteUser(@PathVariable("id") String  id) {
        individualService.deleteIndividualById(id);
        return "individual deleted with success !";
    }

}
