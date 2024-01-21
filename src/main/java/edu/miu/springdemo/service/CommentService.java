package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.dto.request.CommentRequestDTO;
import edu.miu.springdemo.entity.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {

    public void addNewComment(int postId, CommentRequestDTO commentRequestDTO);

    List<CommentResponseDTO> getAllCommentsByPostId(int id);

    public CommentResponseDTO getCommentByIds(int userId, int postId, int commentId);
    List<CommentResponseDTO> getCommentList(int userId,int postId);

}
