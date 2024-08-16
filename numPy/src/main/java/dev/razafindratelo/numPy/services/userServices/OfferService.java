package dev.razafindratelo.numPy.services.userServices;

import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.dtos.postDtos.WishListDto;
import dev.razafindratelo.numPy.entity.post.Offer;

import java.util.List;

public interface OfferService {
    OfferDto createOffer(OfferDto offerDto);
    OfferDto updateOffer(String offerId, OfferDto offerDto);
    OfferDto getOfferById(String id);
    List<OfferDto> getOffers();
    void deleteOffer(String id);
}
