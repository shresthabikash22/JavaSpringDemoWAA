package edu.miu.springdemo.controller;

import edu.miu.springdemo.entity.dto.response.PostDto;
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
    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p){
        postService.save(p);

    }

    @GetMapping("/{id}")
    public PostDto findById(@PathVariable("id") long id){
        return postService.findById(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id,@RequestBody PostDto p){
        postService.update(id,p);
    }

    @GetMapping("/search")
    public List<PostDto> getPostsByAuthor(@RequestParam String author){
        return postService.getPostsByAuthor(author);
    }
}
