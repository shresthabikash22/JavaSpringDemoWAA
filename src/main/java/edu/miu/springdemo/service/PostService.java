package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.Post;
import edu.miu.springdemo.entity.dto.response.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    PostDto findById(long id);

    void save(PostDto p);

    void delete(long id);

    void update(long id, PostDto p);

    List<PostDto> getPostsByAuthor(String author);
}
