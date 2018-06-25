package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostService(PostRepository postDao, UserRepository userDao) {

        this.postDao = postDao;
        this.userDao = userDao;
    }


    public List<Post> findAll() {
        return postDao.findAll();
    }

    public Post save(Post post) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(sessionUser.getId());
        post.setUser(user);
        postDao.save(post);
        return post;
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }

    public void delete(long id){
        postDao.delete(id);
    }

    public List<Post> search(String searchTerm){
        return postDao.search("%" + searchTerm + "%");
    }

}
