package edu.miu.springdemo.service.impl;

import edu.miu.springdemo.entity.Post;
import edu.miu.springdemo.entity.User;
import edu.miu.springdemo.entity.dto.response.PostResponseDTO;
import edu.miu.springdemo.helper.ListMapper;
import edu.miu.springdemo.repo.PostRepo;
import edu.miu.springdemo.repo.UserRepo;
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
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;
    @Override
    public List<PostResponseDTO> findAll() {
        return (List<PostResponseDTO>) listMapper.mapList(postRepo.findAll(),new PostResponseDTO());
    }

    @Override
    public PostResponseDTO findById(int id) {
        return modelMapper.map(postRepo.findById(id), PostResponseDTO.class);
    }

    @Override
    public void save(PostResponseDTO p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void saveUserPost(int userId, PostResponseDTO postResponseDTO) {
       User user =userRepo.findById(userId).orElse(null);
       if(user!=null)
       {
           Post p = modelMapper.map(postResponseDTO,Post.class);
           p.setAuthor(user.getName());
           user.getPosts().add(p);
           userRepo.save(user);
       }

    }

    @Override
    public void delete(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(int id, PostResponseDTO p) {
        PostResponseDTO postToUpdate = modelMapper.map(postRepo.getReferenceById(id), PostResponseDTO.class);
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

    @Override
    public PostResponseDTO getPostById(int userId, int postId) {
        Post post = postRepo.findById(postId).orElse(null);
        if(post!=null)
        {
            return modelMapper.map(post,PostResponseDTO.class);
        }
        return null;
    }

    @Override
    public List<PostResponseDTO> findPostsByTitle(String title) {
        return listMapper.mapList(postRepo.findByTitle(title),new PostResponseDTO());
    }
}
