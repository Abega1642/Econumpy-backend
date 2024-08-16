package dev.razafindratelo.numPy.services.postServices;

import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;

import java.util.List;

public interface OfferService {
    OfferDto createOffer(OfferDto offerDto, String userEmail);
    OfferDto updateOffer(String offerId, OfferDto offerDto);
    OfferDto getOfferById(String id);
    List<OfferDto> getOffers();
    void deleteOffer(String id);
}
