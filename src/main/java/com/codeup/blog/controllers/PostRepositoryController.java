package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostRepositoryController {
    private PostRepository repository;

    public PostRepositoryController(PostRepository repository){
        this.repository = repository;
    }

    @ResponseBody
    @GetMapping("/posts-test")
    public String test() {
        long count = repository.count();

        System.out.format("There are %d posts in the DB.\n", count);

        Iterable<Post> posts = repository.findAll();

        for (Post post : posts) {
            System.out.println(post);
        }
        return "check the console";
    }
}
