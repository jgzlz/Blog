/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.TestConfig;
import com.sg.blog.models.Post;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author G10-DEV10W3
 */
@SpringBootTest(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
public class PostDaoTest {

    @Autowired
    PostDatabaseDao dao;

    @BeforeEach
    public void setup() {
//        kgs.set();
    }

    public PostDaoTest() {
    }

    @Test
    public void testFindByUserIdSuccess() {
        List<Post> user = dao.findByUserId(2);
        assertNotNull(user);
        System.out.println("User: " + user.get(0).getUserId());
        assertEquals(1, user.size());
    }

    @Test
    public void testFindByUserIdFail() {
        List<Post> user = dao.findByUserId(100);
        assertEquals(0, user.size());
    }

    @Test
    public void testFindByPostIdSuccess() {
        List<Post> post = dao.findByPostId(2);
        assertNotNull(post);
        System.out.println("Post: " + post.get(0).getPostId());
        assertEquals(1, post.size());
    }

    @Test
    public void testFindByPostIdFail() {
        List<Post> post = dao.findByPostId(100);
        assertEquals(0, post.size());
    }

}
