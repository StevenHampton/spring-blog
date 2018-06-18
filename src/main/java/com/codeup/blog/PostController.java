package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {


    @GetMapping("/posts")
    public @ResponseBody String postsIndex(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    public @ResponseBody String postsById(@PathVariable int id){
        return String.format("view an individual post, ID page: %d", id);
    }

    @GetMapping("/posts/create")
    public @ResponseBody String createPost(){
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    public @ResponseBody String create(){
        return "create a new post";
    }
}
