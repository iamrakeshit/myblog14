package com.myblog.myblog14.repository;

import com.myblog.myblog14.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
