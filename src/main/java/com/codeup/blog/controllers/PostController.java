package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


    @RequestMapping(path="/posts", method= RequestMethod.GET)
    public String postsIndex(Model view) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("Test Post #1","Random body stuff #1");
        Post post2 = new Post("Test Post #2","Random body stuff #2");
        posts.add(post1);
        posts.add(post2);
        view.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {
        Post post = new Post(id,"Test Post","Random body stuff");
        view.addAttribute("post", post);
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
