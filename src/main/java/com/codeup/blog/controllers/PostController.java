package com.codeup.blog.controllers;

import com.codeup.blog.PostService;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model view) {
        view.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {
        view.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public @ResponseBody
    String edit(@PathVariable long id) {
        return "View the from for editing post #" + id;
    }

    @GetMapping("/posts/create")
    public @ResponseBody
    String create() {
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    public @ResponseBody
    String savePost() {
        return "Saving to the databases";
    }

}
