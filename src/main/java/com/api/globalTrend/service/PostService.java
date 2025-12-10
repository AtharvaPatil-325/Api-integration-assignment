package com.api.globalTrend.service;

import com.api.globalTrend.entity.Post;
import com.api.globalTrend.util.Cache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private List<Post> postCache;
    private final ApiClient apiClient;


    public void loadCache(){
        postCache = apiClient.getPosts();
        Cache.save("cache.json",postCache);
    }
    public PostService(ApiClient apiClient) {
        this.apiClient = apiClient;
        loadCache();
    }
    public List<Post> getAllPosts(Integer userId) {
        if (userId != null) {
            //using stream api :
            return postCache.stream()
                    .filter(p -> p.getUserId() == userId)
                    .collect(Collectors.toList());
        }
        return postCache;
    }

    public Post getPostById(int id) {
        return postCache.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
