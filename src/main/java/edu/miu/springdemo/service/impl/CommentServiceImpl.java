package edu.miu.springdemo.service.impl;

import edu.miu.springdemo.entity.Comment;
import edu.miu.springdemo.entity.Post;
import edu.miu.springdemo.entity.User;
import edu.miu.springdemo.entity.dto.request.CommentRequestDTO;
import edu.miu.springdemo.entity.dto.response.CommentResponseDTO;
import edu.miu.springdemo.helper.ListMapper;
import edu.miu.springdemo.repo.CommentRepo;
import edu.miu.springdemo.repo.PostRepo;
import edu.miu.springdemo.repo.UserRepo;
import edu.miu.springdemo.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Override
    public void addNewComment(int postId, CommentRequestDTO commentRequestDTO) {
            Comment commentToSave = new Comment();
            commentToSave.setName(commentRequestDTO.getName());
            Post post = postRepo.findById(postId).orElse(null);
            if(post!=null){
                commentToSave.setPost(post);
                commentRepo.save(commentToSave);
            }
    }


    @Override
    public List<CommentResponseDTO> getAllCommentsByPostId(int id) {
        return  listMapper.mapList(commentRepo.findAllByPostId(id),new CommentResponseDTO());
    }

    @Override
    public CommentResponseDTO getCommentByIds(int userId, int postId, int commentId) {
        User user =  userRepo.findById(userId).orElse(null);
        if(user!=null){
            Post post = user.getPosts().stream().filter(p->p.getId()==postId).findFirst().orElse(null);
            if(post!=null){
                Comment comment = post.getComments().stream().filter(c-> c.getId() == commentId).findFirst().orElse(null);
                if(comment!=null)
                {
                    return modelMapper.map(comment,CommentResponseDTO.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<CommentResponseDTO> getCommentList(int userId,int postId){
        User user = userRepo.findById(userId).orElse(null);
        if(user!=null){
            Post post = user.getPosts().stream().filter(p->p.getId() == postId).findFirst().orElse(null);
            if(post!=null){
                return listMapper.mapList(post.getComments(),new CommentResponseDTO());
            }
        }
       return null;
    }

}
