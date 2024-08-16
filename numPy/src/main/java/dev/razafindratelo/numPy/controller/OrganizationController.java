package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.services.userServices.IndividualService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizationController {
    private IndividualService individualService;

    @GetMapping("/organization")
    public ResponseEntity<List<IndividualDto>> getIndividuals() {
        List<IndividualDto> individualDtos = individualService.getIndividuals();
        return ResponseEntity.ok(individualDtos);
    }

    @GetMapping("/organization/{organization}")
    public ResponseEntity<IndividualDto> getUser(@PathVariable String individualId) {
        IndividualDto individualDto = individualService.getIndividualById(individualId);
        return ResponseEntity.ok(individualDto);
    }

    @PostMapping("/organization/authentication")
    public ResponseEntity<Boolean> loginUser(@RequestBody IndividualDto individualDto) {
        Boolean check = individualService.checkUserLogin(individualDto);
        return (check) ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/organization/add")
    public ResponseEntity<IndividualDto> createUser(@RequestBody IndividualDto individualDto) {
        IndividualDto addUser = individualService.createIndividual(individualDto);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/organization/update/{individualId}")
    public ResponseEntity<IndividualDto> updateUser(@PathVariable("individualId") String individualId, @RequestBody IndividualDto individualDto) {
        IndividualDto updateUser = individualService.updateIndividual(individualId, individualDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/organization/delete/{id}")
    public String deleteUser(@PathVariable("id") String  id) {
        individualService.deleteIndividualById(id);
        return "individual deleted with success !";
    }
}
