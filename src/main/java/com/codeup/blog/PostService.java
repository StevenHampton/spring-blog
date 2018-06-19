package com.codeup.blog;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return  posts.get((int) (id - 1));
    }

    private void createPosts() {
        Post post1 = new Post(1,"First Post!","Lots of stuff and stuff");
        Post post2 = new Post(2,"Second Post","I think I'm getting the hang of this now");
        Post post3 = new Post(3,"Third Post","I definitely have it now!");
        save(post1);
        save(post2);
        save(post3);
    }
}
