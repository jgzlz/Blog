/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.TestConfig;
import com.sg.blog.models.User;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
public class UserDaoTest {

    @Autowired
    UserDatabaseDao dao;

    public UserDaoTest() {
    }

    @BeforeEach
    public void setup() {
//        kgs.set();
    }

    @Test
    public void testFindByIdSuccess() {
        User actual = dao.findById(1);
        assertNotNull(actual);
    }

    @Test
    public void testFindByIdFail() {
        User actual = dao.findById(100);
        assertNull(actual);
    }

    @Test
    public void testFindAllUsersSuccess() {
        List<User> user = dao.findAllUsers();
        assertNotNull(user);
        System.out.println("User: " + user.get(0).getUserId());
        assertEquals(4, user.size());
    }

//    @Test
//    public void testFindAllUsersFail() {
//        List<User> user = dao.findAllUsers();
//        assertEquals(0, user.size());
//    }
}
