package com.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService {
    public String getToken(List<String> authorization) {
        String s = authorization.get(0);
        String token = s.substring(7);
        return token;
    }
}
