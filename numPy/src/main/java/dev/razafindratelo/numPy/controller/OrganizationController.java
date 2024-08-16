package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.Login;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.services.individualService.IndividualService;
import dev.razafindratelo.numPy.services.organizationService.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class OrganizationController {
    OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization")
    public ResponseEntity<List<OrganizationDto>> getIndividuals() {
        List<OrganizationDto> or = organizationService.getAllOrganization();
        return ResponseEntity.ok(or);
    }

    @GetMapping("/organization/{organization}")
    public ResponseEntity<OrganizationDto> getUser(@PathVariable("organization") String individualId) {
        OrganizationDto individualDto = organizationService.getOrganizationById(individualId);
        return ResponseEntity.ok(individualDto);
    }

    @PostMapping("/organization/authentication")
    public ResponseEntity<Boolean> loginUser(@RequestBody Login login) {
        Boolean check = organizationService.loginUser(login);
        return (check) ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/organization/add")
    public ResponseEntity<OrganizationDto> createUser(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto addUser = organizationService.createOrganization(organizationDto);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/organization/update/{individualId}")
    public ResponseEntity<OrganizationDto> updateUser(@PathVariable("individualId") String individualId, @RequestBody OrganizationDto individualDto) {
        OrganizationDto updateUser = organizationService.updateOrganization(individualId, individualDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/organization/delete/{id}")
    public String deleteUser(@PathVariable("id") String  id) {
        organizationService.deleteEventById(id);
        return "organization deleted with success !";
    }
}
