package edu.miu.springdemo.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {

    private String title;
    private String content;
    private  String author;

}
