package com.codeup.blog;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    public Post findOne(long id) {
        return  postRepository.findOne(id);
    }

    public Post editPost(Post post){
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.delete(id);
    }
    public List<Post> search(String searchTerm) {
         return postRepository.search("%" + searchTerm + "%");
        }

        public List<Post> searchByTitle(String title){
        return postRepository.findByTitle(title);
        }

}
