package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.services.postServices.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OfferController {
    private OfferService offerService;

    @GetMapping("/offer")
    public ResponseEntity<List<OfferDto>> getWishList() {
        List<OfferDto> offerDtoList = offerService.getOffers();
        return ResponseEntity.ok(offerDtoList);
    }

    @GetMapping("/offer/{eventId}")
    public ResponseEntity<OfferDto> getEvent(@PathVariable String offerId) {
        OfferDto offerById = offerService.getOfferById(offerId);
        return ResponseEntity.ok(offerById);
    }

    @PostMapping("/offer/add")
    public ResponseEntity<OfferDto> addOffer(@RequestBody OfferDto offerDto) {
        OfferDto addOffer = offerService.createOffer(offerDto);
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
