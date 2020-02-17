/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.data;

import com.sg.blog.models.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author G10-DEV10W3
 */
public class PostDatabaseDao implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> findByUserId(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post insert(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> findByPostId(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int index) throws SQLException {

            LocalDateTime timestamp = rs.getTimestamp("PostTime").toLocalDateTime();

            Post p = new Post();
            p.setPostId(rs.getInt("postId"));
            p.setUserId(rs.getInt("userId"));
            p.setPost(rs.getString("post"));
            p.setTimestamp(timestamp);

            return p;
        }
    }

}
