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
    @PostMapping("/posts")
    public String selectToEdit(@RequestParam(name = "id") long id){
        return "redirect:/posts/" + id + "/edit";
    }

    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {
        view.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view) {
        Post post = postService.findOne(id);
        view.addAttribute("post", post);
        return "posts/edit";
    }

    @GetMapping("/posts/create")
    public String create(Model view) {
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

}
