package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.entity.post.Post;

public class PostMapper {
    public static PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getNumberOfLike(),
                post.getNumberOfDislike(),
                post.getPublishedDate()
        );
    }
}
