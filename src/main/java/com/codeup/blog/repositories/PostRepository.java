package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long>{
    List<Post> findAll();

    List<Post> findByTitle(String title);

    List<Post> findByTitleLike(String titleSearch, String bodySearch);

    List<Post> findByTitleLikeOrBodyLike(String titleSeach, String bodySearch);

    @Query(nativeQuery = true, value = "SELECT * FROM posts WHERE title LIKE ?1 OR body LIKE ?1")
    List<Post> search(String searchTerm);
}
