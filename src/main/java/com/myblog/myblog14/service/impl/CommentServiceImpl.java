package com.myblog.myblog14.service.impl;

import com.myblog.myblog14.entity.Comment;
import com.myblog.myblog14.entity.Post;
import com.myblog.myblog14.exception.ResourceNotFoundException;
import com.myblog.myblog14.payload.CommentDto;
import com.myblog.myblog14.repository.CommentRepository;
import com.myblog.myblog14.repository.PostRepository;
import com.myblog.myblog14.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    private PostRepository postRepository;

    public CommentServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id " + postId)
        );

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setContent(savedComment.getContent());

        return dto;
    }

}
