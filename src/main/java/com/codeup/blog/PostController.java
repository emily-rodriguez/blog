package com.codeup.blog;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String index(Model view){
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(1,"Post 1", "Blah blah blah");
        Post post2 = new Post(2, "Post 2", "Blah blah blah");
        posts.add(post1);
        posts.add(post2);
        view.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model view){
        Post post = new Post("Post", "Here's a post");
        view.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public @ResponseBody String edit(@PathVariable long id){
        return "View the form for editing post # " + id;
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model view){
        view.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        postService.save(post);
        System.out.println(post);
        return "redirect:/posts";
    }
}
