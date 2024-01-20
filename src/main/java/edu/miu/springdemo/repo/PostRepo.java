package edu.miu.springdemo.repo;

import edu.miu.springdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByAuthor(String author);
    List<Post> findByAuthorContainingIgnoreCase(String text);

    List<Post> findByTitle(String title);

}
