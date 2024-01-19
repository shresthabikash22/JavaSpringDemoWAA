package edu.miu.springdemo.service.impl;

import edu.miu.springdemo.entity.User;
import edu.miu.springdemo.entity.dto.request.UserRequestDTO;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.entity.dto.response.UserResponseDTO;
import edu.miu.springdemo.helper.ListMapper;
import edu.miu.springdemo.repo.UserRepo;
import edu.miu.springdemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;


    @Override
    public List<UserResponseDTO> findAll() {
        return(List<UserResponseDTO>)listMapper.mapList( userRepo.findAll(), new UserResponseDTO());
    }

    @Override
    public UserResponseDTO findById(long id) {
        return modelMapper.map(userRepo.findById((int)id),UserResponseDTO.class);
    }

    @Override
    public void save(UserRequestDTO u) {
        userRepo.save(modelMapper.map(u, User.class));
    }

    @Override
    public List<PostResponseDTO> findAllPostByUserId(long id) {
        return listMapper.mapList(userRepo.findById((int)id).orElseThrow().getPosts(), new UserResponseDTO() );
    }
}
