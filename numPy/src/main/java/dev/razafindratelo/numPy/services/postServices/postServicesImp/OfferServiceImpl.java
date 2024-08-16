package dev.razafindratelo.numPy.services.postServices.postServicesImp;

import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.services.postServices.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {
    @Override
    public OfferDto createOffer(OfferDto offerDto) {
        return null;
    }

    @Override
    public OfferDto updateOffer(String offerId, OfferDto offerDto) {
        return null;
    }

    @Override
    public OfferDto getOfferById(String id) {
        return null;
    }

    @Override
    public List<OfferDto> getOffers() {
        return List.of();
    }

    @Override
    public void deleteOffer(String id) {

    }
}
