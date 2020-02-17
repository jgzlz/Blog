/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.models.Post;
import java.util.List;

/**
 *
 * @author G10-DEV10W3
 */
public interface PostDao {

    List<Post> findByUserId(int userId);
    
    List<Post> findByPostId(int postId);
    
    Post insert(Post post);
}
