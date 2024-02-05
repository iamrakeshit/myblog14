package com.myblog.myblog14.controller;

import com.myblog.myblog14.payload.PostDto;
import com.myblog.myblog14.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//      http://localhost:8080/rest/api
@RestController
@RequestMapping("/rest/api")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
@PostMapping
    public ResponseEntity<PostDto> createRegistration(@RequestBody PostDto postDto){
         PostDto dto = postService.createRegistration(postDto);
         return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
   //    http://localhost:8080/rest/api?id=1
@GetMapping
    public ResponseEntity<PostDto> getRegistrationById(@RequestParam long id){
        PostDto byId = postService.getRegistrationByID(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }
    //    http://localhost:8080/rest/api/getall?pageNo=0&pageSize=3&sortBy=name
@GetMapping("getall")
    public List<PostDto> getAllRegistration(
            @RequestParam(name="pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name="pageSize", required = false, defaultValue = "3")int pageSize,
            @RequestParam(name="sortBy", required = false, defaultValue = "id")String sortBy
    ){
        List<PostDto> post = postService.getAllRegistration(pageNo, pageSize,sortBy);
        return post;
    }
}
