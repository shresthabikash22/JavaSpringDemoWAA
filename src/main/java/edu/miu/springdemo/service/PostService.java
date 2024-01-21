package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.dto.response.PostResponseDTO;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> findAll();
    PostResponseDTO findById(int id);

    void save(PostResponseDTO p);
    void saveUserPost(int userId,PostResponseDTO post);
    void delete(int id);

    void update(int id, PostResponseDTO p);

    List<PostResponseDTO> getPostsByAuthor(String author);
    List<PostResponseDTO> getPostsByAuthorText(String author);
    public PostResponseDTO getPostById(int userId, int postId);

    List<PostResponseDTO> findPostsByTitle(String title);
}
