package com.codeup.blog;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }


    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public Post save(Post post) {
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
        postDao.save(post);
    }

}
