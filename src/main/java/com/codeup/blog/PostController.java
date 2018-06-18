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
    public @ResponseBody String showDetails(@PathVariable long id){
        return "view an individual post #" + id;
    }

    @GetMapping("/posts/{id}/edit")
    public @ResponseBody String edit(@PathVariable long id){
        return "View the from for editing post #" + id;
    }

    @GetMapping("/posts/create")
    public @ResponseBody String create(){
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    public @ResponseBody String savePost(){
        return "Saving to the databases";
    }
}
