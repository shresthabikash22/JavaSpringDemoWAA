package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.dto.request.UserRequestDTO;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.entity.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll(String PostTitle);

    UserResponseDTO findById(int id);

    void save(UserRequestDTO u);

    void deleteUser(int userId);

    List<PostResponseDTO> findAllPostByUserId(int id);

    List<PostResponseDTO> findPostByUserIdAndPostId(int userId,int postId);

    List<UserResponseDTO> findUsersWithMoreThanNPosts(int num);



}
