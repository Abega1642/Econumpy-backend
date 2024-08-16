package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.entity.post.Offer;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.mapper.userMapper.UserMapper;

public class OfferMapper {
    public static OfferDto mapToPostDto(Offer post) {
        return new OfferDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getNumberOfLike(),
                post.getNumberOfDislike(),
                post.getPublishedDate(),
                UserMapper.MapUserToUserDto(post.getAuthor()),
                post.getStatus()
        );
    }
    public static Offer mapToPost(OfferDto offerDto) {
        return new Offer(
                offerDto.getPostId(),
                offerDto.getTitle(),
                offerDto.getDescription(),
                offerDto.getLike(),
                offerDto.getDislike(),
                offerDto.getPublishedDate(),
                offerDto.getStatus(),
                UserMapper.MapUserToUser(offerDto.getAuthor())
                );
    }
}
