package com.myblog.myblog14.service.impl;

import com.myblog.myblog14.entity.Post;
import com.myblog.myblog14.exception.ResourceNotFoundException;
import com.myblog.myblog14.payload.PostDto;
import com.myblog.myblog14.repository.PostRepository;
import com.myblog.myblog14.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createRegistration(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post spost = postRepository.save(post);
        PostDto dto = mapToDto(spost);
        return dto;
    }

    @Override
    public PostDto getRegistrationByID(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Registration is not found with id "+ id)
        );
        PostDto dto = mapToDto(post);
        return dto;
    }

    @Override
    public List<PostDto> getAllRegistration(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Post> pagePosts = postRepository.findAll(pageable);
        List<Post>posts = pagePosts.getContent();
        List<PostDto> collectedPosts = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return collectedPosts;
    }

    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setName(postDto.getName());
        post.setEmail(postDto.getEmail());
        post.setMobile(postDto.getMobile());
        return post;
    }
    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }
}
