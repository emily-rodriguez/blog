package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM posts WHERE title LIKE ?1 OR body LIKE ?1")
    List<Post> search(String searchTerm);
}
