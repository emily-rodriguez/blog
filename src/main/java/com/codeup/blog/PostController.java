package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("Post 1", "Blah blah blah");
        Post post2 = new Post("Post 2", "Blah blah blah");
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model){
        Post post = new Post("Post", "Here's a post");
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public @ResponseBody String edit(@PathVariable long id){
        return "View the form for editing post # " + id;
    }

    @GetMapping("/posts/create")
    public @ResponseBody String getCreatePost(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public @ResponseBody String createPost(){
        return "create a new post";
    }
}
