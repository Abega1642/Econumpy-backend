package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.OfferDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.entity.post.Offer;
import dev.razafindratelo.numPy.entity.post.Post;

public class OfferMapper {
    public static OfferDto mapToPostDto(Offer post) {
        return new OfferDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getNumberOfLike(),
                post.getNumberOfDislike(),
                post.getPublishedDate()
        );
    }
}
