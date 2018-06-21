package com.codeup.blog;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get(((int) id) - 1);
    }

    public void createPosts() {
        save(new Post("Post #1", "This is a test"));
        save(new Post("Post #2", "This is another test"));
        save(new Post("Post #3", "This is a third test"));
    }

}
