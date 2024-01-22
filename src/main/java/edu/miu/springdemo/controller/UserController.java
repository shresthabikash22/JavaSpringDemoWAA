package edu.miu.springdemo.controller;

import edu.miu.springdemo.aspect.annotation.ExecutionTime;
import edu.miu.springdemo.entity.User;
import edu.miu.springdemo.entity.dto.request.CommentRequestDTO;
import edu.miu.springdemo.entity.dto.request.UserRequestDTO;
import edu.miu.springdemo.entity.dto.response.CommentResponseDTO;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.entity.dto.response.UserResponseDTO;
import edu.miu.springdemo.service.CommentService;
import edu.miu.springdemo.service.PostService;
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
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
//
    @GetMapping
    public List<UserResponseDTO> findAll(@RequestParam(required = false,defaultValue = "")String postTitle){

        return userService.findAll(postTitle);
    }
    @ExecutionTime
    @GetMapping("/{uid}")
    public UserResponseDTO findById(@PathVariable("uid") int uid){
        return userService.findById(uid);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserRequestDTO usr){
        userService.save(usr);

    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }
    @GetMapping("/exception-test")
    public void exceptionTest() throws Exception{
            throw new Exception("Exception from user");
    }

/**  -----------------------------  POSTS ----------------------------**/
    @GetMapping("/{userId}/posts")
    public List<PostResponseDTO> findPostsByUserId(@PathVariable("userId") int userId,@RequestParam(required = false,defaultValue = "") String title){
        if(title.isEmpty()){
            return userService.findAllPostByUserId(userId);
        }
        return postService.findPostsByTitle(title);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public PostResponseDTO findPostById(@PathVariable int userId, @PathVariable int postId){
        return postService.getPostById(userId,postId);
    }


    @GetMapping("filter/posts/{num}")
    public List<UserResponseDTO>  findUsersWithPosts (@PathVariable int num){
        return userService.findUsersWithMoreThanNPosts(num);
    }

    @PostMapping("/{userId}/posts")
    public void savePost(@PathVariable int userId,@RequestBody PostResponseDTO post){

        postService.saveUserPost(userId,post);
    }

    /**   -------------------- Comments -----------------**/
    @PostMapping("/{userId}/posts/{postId}/comments")
    public void addNewComment(@PathVariable int userId, @PathVariable int postId, @RequestBody CommentRequestDTO commentRequestDTO){
         commentService.addNewComment(postId,commentRequestDTO);
    }
    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public CommentResponseDTO getCommentsByIds(@PathVariable int userId,@PathVariable int postId,@PathVariable int commentId){
        return commentService.getCommentByIds(userId, postId, commentId);
    }

    @GetMapping("/{userId}/posts/{postId}/comments")
    public List<CommentResponseDTO> getCommentList(@PathVariable int userId, @PathVariable int postId){
        return commentService.getCommentList(userId, postId);
    }




}
