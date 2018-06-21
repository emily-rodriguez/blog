package com.codeup.blog.controllers;

import com.codeup.blog.PostService;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String index(Model view){
        view.addAttribute("posts", postService.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model view){
        Post post = new Post("Post", "Here's a post");
        view.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view){
        view.addAttribute("post", postService.findOne(id));
        return "/posts/edit";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model view){
        view.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

}
