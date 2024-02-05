package com.myblog.myblog14.service;

import com.myblog.myblog14.payload.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);

    void deleteComment(long id);
}
