package edu.miu.springdemo.entity.dto.response.post;

import edu.miu.springdemo.entity.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRESPDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private  String content;
    private  String author;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="postId")
    private List<Comment> comments;
}
