package dev.razafindratelo.numPy.services.postServices.postServicesImp;

import dev.razafindratelo.numPy.Exceptions.ResourceNotFoundException;
import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.entity.post.Offer;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.postMapper.OfferMapper;
import dev.razafindratelo.numPy.repositories.postRepository.PostRepository;
import dev.razafindratelo.numPy.services.postServices.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {

    PostRepository offerRepository;

    @Override
    public OfferDto createOffer(OfferDto offerDto, User user) {
        Offer offerDto1 = offerRepository.save(OfferMapper.mapToPost(offerDto, user));
        return OfferMapper.mapToPostDto(offerDto1);
    }

    @Override
    public OfferDto updateOffer(String offerId, OfferDto offerDto) {
        Offer offer = (Offer) offerRepository.findById(offerId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Individual with id " + offerId + " not found")
                );
        offer.setStatus(offerDto.getStatus());
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
        List<Post> posts = offerRepository.findAll();

        List<Offer> offerList = new ArrayList<>();

        for (Post post : posts) {
            if (post instanceof Offer) {
                offerList.add((Offer) post);
            }
        }
        return offerList.stream()
                .map(OfferMapper::mapToPostDto)
                .toList();
    }

    @Override
    public void deleteOffer(String id) {
        offerRepository.deleteById(id);
    }
}
