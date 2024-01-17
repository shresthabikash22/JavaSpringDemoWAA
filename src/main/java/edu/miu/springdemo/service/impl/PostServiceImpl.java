package edu.miu.springdemo.service.impl;

import edu.miu.springdemo.entity.Post;
import edu.miu.springdemo.entity.dto.response.PostDto;
import edu.miu.springdemo.helper.ListMapper;
import edu.miu.springdemo.repo.PostRepo;
import edu.miu.springdemo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;
    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(postRepo.findAll(),new PostDto());
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, PostDto p) {
        postRepo.update(id,modelMapper.map(p,Post.class));
    }

    @Override
    public List<PostDto> getPostsByAuthor(String author) {
        return (List<PostDto>) listMapper.mapList(postRepo.getPostsByAuthor(author),new PostDto());
    }
}
