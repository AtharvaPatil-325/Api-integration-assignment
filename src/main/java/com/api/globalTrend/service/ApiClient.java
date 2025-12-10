package com.api.globalTrend.service;


import com.api.globalTrend.entity.Post;
import com.api.globalTrend.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiClient {

    private final String POST_Url = "https://jsonplaceholder.typicode.com/posts";
    private final String Users_Url = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Post> getPosts() {
        Post[] posts = restTemplate.getForObject(POST_Url, Post[].class);
        return Arrays.asList(posts);
    }
    public List<User> getUsers() {
        User user = restTemplate.getForObject(Users_Url, User.class);
        return Arrays.asList(user);
    }

}
