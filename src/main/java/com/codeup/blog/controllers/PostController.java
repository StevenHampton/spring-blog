package com.codeup.blog.controllers;

import com.codeup.blog.PostService;
import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
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
    public String index(Model view, @RequestParam(name = "search", required = false) String searchTerm) {
        List<Post> posts;
        if(searchTerm == null){
            posts = postService.findAll();
        }else{
            posts = postService.search(searchTerm);
        }

        view.addAttribute("posts", posts);
        view.addAttribute("searchTerm", searchTerm);

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

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        postService.editPost(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postService.deletePost(id);
        return "redirect:/posts";
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

    @GetMapping("/seed")
    public String seedPosts() {
        postService.save(new Post("Choose the perfect design", "Create a beautiful blog that fits your style. Choose from a selection of easy-to-use templates – all with flexible layouts and hundreds of background images – or design something new."));
        postService.save(new Post("Get a free domain", "Give your blog the perfect home. Get a free blogspot.com domain or buy a custom domain with just a few clicks."));
        postService.save(new Post("Earn money", "Get paid for your hard work. Google AdSense can automatically display relevant targeted ads on your blog so that you can earn income by posting about your passion."));
        postService.save(new Post("Know your audience", "Find out which posts are a hit with Blogger’s built-in analytics. You’ll see where your audience is coming from and what they’re interested in. You can even connect your blog directly to Google Analytics for a more detailed look."));
        postService.save(new Post("Hang onto your memories", "Save the moments that matter. Blogger lets you safely store thousands of posts, photos, and more with Google for free."));
        postService.save(new Post("Join millions of others", "Whether sharing your expertise, breaking news, or whatever’s on your mind, you’re in good company on Blogger. Sign up to discover why millions of people have published their passions here."));
        return "redirect:/posts";
    }

}
