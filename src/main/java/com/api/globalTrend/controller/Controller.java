package com.api.globalTrend.controller;


import com.api.globalTrend.entity.Post;
import com.api.globalTrend.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class Controller {
    private final PostService pService;

    public Controller(PostService postService) {
        this.pService = postService;
    }

    @GetMapping
    public List<Post> getPosts(@RequestParam(required = false) Integer uId) {
        return pService.getAllPosts(uId);
    }

    @GetMapping("/{id}")
    public Object getPostById(@PathVariable int id) {
        Post post = pService.getPostById(id);
        if (post == null) {
            return new Error("Post not found");
        }
        return post;
    }
}

