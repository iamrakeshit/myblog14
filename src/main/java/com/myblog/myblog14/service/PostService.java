package com.myblog.myblog14.service;

import com.myblog.myblog14.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDto createRegistration(PostDto postDto);
    PostDto getRegistrationByID(long id);

    List<PostDto> getAllRegistration(int pageNo, int pageSize, String sortBy);
}
