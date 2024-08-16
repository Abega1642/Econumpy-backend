package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.mapper.userMapper.UserMapper;

public class PostMapper {
    public static PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getNumberOfLike(),
                post.getNumberOfDislike(),
                post.getPublishedDate(),
                UserMapper.MapUserToUserDto(post.getAuthor())
        );
    }

    public static Post mapToPost(PostDto post) {
        return new Post(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getLike(),
                post.getDislike(),
                post.getPublishedDate(),
                UserMapper.MapUserToUser(post.getAuthor())
        );
    }
}
