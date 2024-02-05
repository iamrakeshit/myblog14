package com.myblog.myblog14.controller;

import com.myblog.myblog14.payload.CommentDto;
import com.myblog.myblog14.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//      http://localhost:8080/rest/comment?postId=1
@RestController
@RequestMapping("/rest/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @RequestParam long postId){
        commentService.createComment(commentDto,postId);
    }
}
