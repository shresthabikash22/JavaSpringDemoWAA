package edu.miu.springdemo.repo;

import edu.miu.springdemo.entity.Post;

import java.util.List;

public interface PostRepo {
   List<Post> findAll();
   Post findById(long id);
   void save(Post p);

   void delete(long id);

   void update(long id, Post p);

   List<Post> getPostsByAuthor(String author);
}
