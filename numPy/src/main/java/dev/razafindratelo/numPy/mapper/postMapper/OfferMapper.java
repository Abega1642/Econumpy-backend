package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.entity.post.Offer;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.entity.post.Status;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.statusMapper.StatusMapper;
import dev.razafindratelo.numPy.mapper.userMapper.UserMapper;
import dev.razafindratelo.numPy.repositories.userRepository.UserRepository;
import dev.razafindratelo.numPy.services.individualService.individualImp.IndividualServiceImp;
import dev.razafindratelo.numPy.services.userServices.IndividualService;
import dev.razafindratelo.numPy.services.userServices.UserService;

public class OfferMapper {
    public static OfferDto mapToPostDto(Offer post) {
        return new OfferDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getNumberOfLike(),
                post.getNumberOfDislike(),
                post.getPublishedDate(),
                post.getAuthor().getEmail(),
                post.getStatus()
        );
    }
    public static Offer mapToPost(OfferDto offerDto, User user) {
        return new Offer(
                offerDto.getPostId(),
                offerDto.getTitle(),
                offerDto.getDescription(),
                offerDto.getLike(),
                offerDto.getDislike(),
                offerDto.getPublishedDate(),
                offerDto.getStatus(),
                user
                );
    }
}
