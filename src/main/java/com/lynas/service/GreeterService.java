package com.lynas.service;

/**
 * Created by sazzad on 2/15/16.
 */
public class GreeterService {
    private String content;

    public GreeterService(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
