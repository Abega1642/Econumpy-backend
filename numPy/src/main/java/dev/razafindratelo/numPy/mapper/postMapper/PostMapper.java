package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.entity.user.User;
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
                post.getAuthor().getEmail()
        );
    }

    public static Post mapToPost(PostDto post, User user) {
        return new Post(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getLike(),
                post.getDislike(),
                post.getPublishedDate(),
                user
        );
    }
}
