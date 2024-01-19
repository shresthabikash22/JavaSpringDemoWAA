package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.dto.response.PostResponseDTO;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> findAll();
    PostResponseDTO findById(long id);

    void save(PostResponseDTO p);

    void delete(long id);

    void update(long id, PostResponseDTO p);

    List<PostResponseDTO> getPostsByAuthor(String author);
    List<PostResponseDTO> getPostsByAuthorText(String author);
}
