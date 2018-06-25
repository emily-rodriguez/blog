package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }


    public List<Post> findAll() {
        return postDao.findAll();
    }

    public Post save(Post post) {
        System.out.println(post.getUser().getId());
        postDao.save(post);
        return post;
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }

    public void delete(long id){
        postDao.delete(id);
    }

    public void update(Post post) {
        System.out.println(post.getUser().getId());
        postDao.save(post);
    }

    public List<Post> search(String searchTerm){
        return postDao.search("%" + searchTerm + "%");
    }

}
