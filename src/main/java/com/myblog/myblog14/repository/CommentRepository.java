package com.myblog.myblog14.repository;

import com.myblog.myblog14.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
