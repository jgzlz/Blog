/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.models;

import java.time.LocalDateTime;

/**
 *
 * @author G10-DEV10W3
 */
public class Post {

    private int postId;
    private int userId;
    private String postMessage;
    private LocalDateTime timestamp = LocalDateTime.now();

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Post() {

    }

    public Post(int postId, int userId, String post, LocalDateTime timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.postMessage = postMessage;
        this.timestamp = timestamp;
    }

}
