package dev.razafindratelo.numPy.services.postServices.postServicesImp;

import dev.razafindratelo.numPy.Exceptions.ResourceNotFoundException;
import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.entity.post.Offer;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.mapper.postMapper.OfferMapper;
import dev.razafindratelo.numPy.mapper.statusMapper.StatusMapper;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.repositories.postRepository.PostRepository;
import dev.razafindratelo.numPy.services.individualService.IndividualService;
import dev.razafindratelo.numPy.services.individualService.individualImp.IndividualServiceImp;
import dev.razafindratelo.numPy.services.postServices.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {

    PostRepository offerRepository;

    @Override
    public OfferDto createOffer(OfferDto offerDto, String userEmail) {
        IndividualService individualService = new IndividualServiceImp();
        Individual individual = IndividualMapper.toIndividual(individualService.getIndividualById(userEmail));
        Offer offer = OfferMapper.mapToPost(offerDto, individual);
        offerRepository.save(offer);
        return OfferMapper.mapToPostDto(offer);
    }

    @Override
    public OfferDto updateOffer(String offerId, OfferDto offerDto) {
        Offer offer = (Offer) offerRepository.findById(offerId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Individual with id " + offerId + " not found")
                );
        offer.setStatus(StatusMapper.statusMapper2(offerDto.getStatus()));
        offer.setTitle(offerDto.getTitle());
        offer.setDescription(offerDto.getDescription());

        Offer updateOffer = offerRepository.save(offer);
        return OfferMapper.mapToPostDto(updateOffer);

    }

    @Override
    public OfferDto getOfferById(String id) {
        Offer offer =(Offer) offerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Individual with id " + id + " not found"));
        return OfferMapper.mapToPostDto(offer);
    }

    @Override
    public List<OfferDto> getOffers() {
        List<Offer> offers = Collections.singletonList((Offer) offerRepository.findAll());

        return offers.stream()
                .map(OfferMapper::mapToPostDto)
                .toList();
    }

    @Override
    public void deleteOffer(String id) {
        offerRepository.deleteById(id);
    }
}
