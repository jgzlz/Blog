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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author G10-DEV10W3
 */
@Repository
public class UserDatabaseDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public User findById(int userId) {
        final String sql = "SELECT userId, firstName, lastName, userName FROM user WHERE userId = ?;";
        return jdbcTemplate.query(sql, new UserMapper(), userId)
                .stream().findAny().orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        final String sql = "SELECT userId, firstName, lastName, userName FROM user ";
         
        return jdbcTemplate.query(sql, new UserMapper());
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
