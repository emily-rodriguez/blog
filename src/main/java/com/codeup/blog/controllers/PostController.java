package com.codeup.blog.controllers;

import com.codeup.blog.PostService;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final UserRepository userRepository;

    public PostController(PostService postService, UserRepository userRepository){
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String index(Model view, @RequestParam(name="search", required = false) String searchTerm){
        List<Post> posts;
        if(searchTerm == null){
            posts = postService.findAll();
        } else {
            posts = postService.search(searchTerm);
        }
        view.addAttribute("posts", posts);
        view.addAttribute("searchterm", searchTerm);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model view){
        Post post = postService.findOne(id);
        view.addAttribute("post", post);
        view.addAttribute("email", post.getUser().getEmail());
        return "/posts/show";
    }


    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view){
        view.addAttribute("post", postService.findOne(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @ModelAttribute Post post){
        postService.update(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model view){
        view.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userRepository.findOne(1L);
        post.setUser(user);
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postService.delete(id);
        return "redirect:/posts";
    }

}
