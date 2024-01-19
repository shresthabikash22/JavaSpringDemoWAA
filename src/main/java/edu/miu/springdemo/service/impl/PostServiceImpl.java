package edu.miu.springdemo.service.impl;

import edu.miu.springdemo.entity.Post;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
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
    public List<PostResponseDTO> findAll() {
        return (List<PostResponseDTO>) listMapper.mapList(postRepo.findAll(),new PostResponseDTO());
    }

    @Override
    public PostResponseDTO findById(long id) {
        return modelMapper.map(postRepo.findById((int)id), PostResponseDTO.class);
    }

    @Override
    public void save(PostResponseDTO p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById((int)id);
    }

    @Override
    public void update(long id, PostResponseDTO p) {
        PostResponseDTO postToUpdate = modelMapper.map(postRepo.getReferenceById((int)id), PostResponseDTO.class);
        postToUpdate.setContent(p.getContent());
        postToUpdate.setTitle(p.getTitle());
        postToUpdate.setAuthor(p.getAuthor());
        postRepo.save(modelMapper.map(postToUpdate,Post.class));
    }

    @Override
    public List<PostResponseDTO> getPostsByAuthor(String author) {
        return (List<PostResponseDTO>) listMapper.mapList(postRepo.findByAuthor(author),new PostResponseDTO());

    }

    @Override
    public List<PostResponseDTO> getPostsByAuthorText(String author) {
        return (List<PostResponseDTO>) listMapper.mapList(postRepo.findByAuthorContainingIgnoreCase(author),new PostResponseDTO());

    }
}
