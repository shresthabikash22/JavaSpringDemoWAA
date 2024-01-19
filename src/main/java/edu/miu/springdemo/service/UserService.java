package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.dto.request.UserRequestDTO;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.entity.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll();

    UserResponseDTO findById(long id);

    void save(UserRequestDTO u);

    List<PostResponseDTO> findAllPostByUserId(long id);

}
