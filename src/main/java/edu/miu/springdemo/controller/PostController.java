package edu.miu.springdemo.controller;

import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<PostResponseDTO> findAll(){
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostResponseDTO p){
        postService.save(p);
    }

    @GetMapping("/{id}")
    public PostResponseDTO findById(@PathVariable("id") int id){
        return postService.findById(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id,@RequestBody PostResponseDTO p){
        postService.update(id,p);
    }

    @GetMapping("/byAuthor")
    public List<PostResponseDTO> getPostsByAuthor(@RequestParam String author){
        return postService.getPostsByAuthor(author);
    }

    @GetMapping("/byAuthorText")
    public List<PostResponseDTO> getPostsByAuthorText(@RequestParam String text){
        return postService.getPostsByAuthorText(text);
    }
}
