package me.about.intro.controller;

import me.about.intro.dto.PostDto;
import me.about.intro.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/find/{id}")
    public PostDto findPost(@PathVariable(name = "id") long id) {
        return postService.findPost(id);
    }

    @PostMapping("/register")
    public PostDto registerPost(PostDto postDto) {
        return postService.registerPost(postDto);
    }



}
