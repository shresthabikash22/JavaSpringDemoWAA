package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.dto.request.PostRequestDTO;
import edu.miu.springdemo.entity.dto.response.post.PostRESPDTO;
import edu.miu.springdemo.entity.dto.response.post.PostResponseDTO;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> findAll();
    PostRESPDTO findById(int id);

    void save(PostRequestDTO p);
    void saveUserPost(int userId,PostResponseDTO post);
    void delete(int id);

    void update(int id, PostResponseDTO p);

    List<PostResponseDTO> getPostsByAuthor(String author);
    List<PostResponseDTO> getPostsByAuthorText(String author);
    public PostResponseDTO getPostById(int userId, int postId);

    List<PostResponseDTO> findPostsByTitle(String title);
}
