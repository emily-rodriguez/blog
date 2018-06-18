package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public @ResponseBody String getPosts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    public @ResponseBody String getPost(@PathVariable String id){
        return String.format("view and individual post with id of %s", id);
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
