package com.myblog.myblog14.service;

import com.myblog.myblog14.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);
}
