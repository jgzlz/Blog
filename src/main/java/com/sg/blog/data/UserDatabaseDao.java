/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author G10-DEV10W3
 */
public class UserDatabaseDao implements UserDao {

    @Override
    public User findById(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {

            User u = new User();
            u.setUserId(rs.getInt("userId"));
            u.setFirstName(rs.getString("firstName"));
            u.setLastName(rs.getString("lastName"));
            u.setUserName(rs.getString("userName"));

            return u;
        }
    }
}
