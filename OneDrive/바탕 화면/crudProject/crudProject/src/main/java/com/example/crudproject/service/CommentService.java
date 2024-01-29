package com.example.crudproject.service;

import com.example.crudproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    //댓글 작성 

      public CommentDto createComment(Long articleId,
                              Long userId,
                              CommentDto dto) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow();
        User user = userRepository.findById(userId)
                .orElseThrow();
        Comment comment = new Comment(
                dto.getContent(), article,user
        );

      return  CommentDto.fromEntity(commentRepository.save(comment));
    }
}
