package edu.miu.springdemo.controller;

import edu.miu.springdemo.entity.dto.request.UserRequestDTO;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.entity.dto.response.UserResponseDTO;
import edu.miu.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
//
    @GetMapping
    public List<UserResponseDTO> findAll(){return userService.findAll();}
    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserRequestDTO usr){
        userService.save(usr);

    }

    @GetMapping("/{id}/posts")
    public List<PostResponseDTO> findPostsByUserId(@PathVariable("id") long id){
        return userService.findAllPostByUserId(id);
    }



}
