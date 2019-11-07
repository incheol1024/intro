package me.about.intro.service;

import me.about.intro.dto.PostDto;
import me.about.intro.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public PostDto findPost(long id) {
        return postRepository.findById(id)
        .orElseThrow(() -> new RuntimeException()).toDto();
    }

    public PostDto registerPost(PostDto postDto) {
        return postRepository.save(postDto.toEntity()).toDto();
    }
}
