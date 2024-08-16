package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.mapper.userMapper.organizationMapper.OrganizationMapper;
import dev.razafindratelo.numPy.services.individualService.IndividualService;
import dev.razafindratelo.numPy.services.organizationService.OrganizationService;
import dev.razafindratelo.numPy.services.postServices.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OfferController {

    OfferService offerService;
    IndividualService individualService;
    OrganizationService organizationService;

    @GetMapping("/offer")
    public ResponseEntity<List<OfferDto>> getWishList() {
        List<OfferDto> offerDtoList = offerService.getOffers();
        return ResponseEntity.ok(offerDtoList);
    }

    @GetMapping("/offer/{eventId}")
    public ResponseEntity<OfferDto> getEvent(@PathVariable("eventId") String offerId) {
        OfferDto offerById = offerService.getOfferById(offerId);
        return ResponseEntity.ok(offerById);
    }

    @PostMapping("/offer/add/{userEmail}")
    public ResponseEntity<OfferDto> addOffer(@RequestBody OfferDto offerDto, @PathVariable("userEmail") String userEmail ) {
        Individual individual = IndividualMapper.toIndividual(individualService.getIndividualById(userEmail));

        Organization organization = OrganizationMapper.toOrganization(organizationService.getOrganizationById(userEmail));
        OfferDto addOffer;
        if (individual == null) {

            addOffer = offerService.createOffer(offerDto, organization);

        } else {
            addOffer = offerService.createOffer(offerDto, individual);
        }
        return new ResponseEntity<>(addOffer, HttpStatus.CREATED);
    }

    @PutMapping("/offer/update/{offerId}")
    public ResponseEntity<OfferDto> updateEvent(@PathVariable("offerId") String offerId, @RequestBody OfferDto offerDto) {
        OfferDto updateOffer = offerService.updateOffer(offerId, offerDto);
        return new ResponseEntity<>(updateOffer, HttpStatus.OK);
    }

    @DeleteMapping("/offer/delete/{offerId}")
    public String deleteOffer(@PathVariable("offerId") String  offerId) {
        offerService.deleteOffer(offerId);
        return "Offer deleted with success !";
    }
}
