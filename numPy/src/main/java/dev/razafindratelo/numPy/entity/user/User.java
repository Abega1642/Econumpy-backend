package dev.razafindratelo.numPy.entity.user;

import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.post.Post;

import java.util.List;

public abstract class User {
    protected String email;
    protected String password;
    protected String address;
    protected String phoneNumber;
    protected String username;
    protected List<Community> communityList;
    protected List<Post> posts;
    protected long score;

}
