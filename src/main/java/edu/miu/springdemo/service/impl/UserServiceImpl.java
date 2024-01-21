package edu.miu.springdemo.service.impl;

import edu.miu.springdemo.entity.Post;
import edu.miu.springdemo.entity.User;
import edu.miu.springdemo.entity.dto.request.UserRequestDTO;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.entity.dto.response.UserResponseDTO;
import edu.miu.springdemo.helper.ListMapper;
import edu.miu.springdemo.repo.UserRepo;
import edu.miu.springdemo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
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
    public List<UserResponseDTO> findAll(String postTitle) {
        if(postTitle.equals("")) {
            return (List<UserResponseDTO>) listMapper.mapList(userRepo.findAll(), new UserResponseDTO());
        }
        else{
            return (List<UserResponseDTO>) listMapper.mapList(userRepo.findUsersByPostTitle(postTitle), new UserResponseDTO());
        }
    }

    @Override
    public UserResponseDTO findById(int id) {
        return modelMapper.map(userRepo.findById(id),UserResponseDTO.class);
    }

    @Override
    public void save(UserRequestDTO u) {
        userRepo.save(modelMapper.map(u, User.class));
    }

    @Override
    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<PostResponseDTO> findAllPostByUserId(int id) {
        List<Post> posts = userRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found")).getPosts();
        return listMapper.mapList(posts, new PostResponseDTO());
    }

    @Override
    public List<PostResponseDTO> findPostByUserIdAndPostId(int userId, int postId) {

        return null;
    }

    @Override
    public List<UserResponseDTO> findUsersWithMoreThanNPosts(int num) {
       List<User> users=userRepo.findUsersWithMMoreThanNPosts(num);
       return listMapper.mapList(users,new UserResponseDTO());
    }


}
