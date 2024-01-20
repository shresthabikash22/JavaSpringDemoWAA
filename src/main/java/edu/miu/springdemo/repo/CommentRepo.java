package edu.miu.springdemo.repo;

import edu.miu.springdemo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {
    @Query("select c from Comment c join c.post p where p.id = :postId")
    List<Comment> findAllByPostId(int postId);
}
