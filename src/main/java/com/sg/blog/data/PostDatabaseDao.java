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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author G10-DEV10W3
 */
@Repository
public class PostDatabaseDao implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> findByUserId(int userId) {
        final String sql = "SELECT postId, userId, postMessage, postTime FROM Post WHERE PostId = ?;";
        return jdbcTemplate.query(sql, new PostMapper(), userId);
    }

    @Transactional
    @Override
    public Post insert(Post post) {
        String sql = "INSERT INTO post (postMessage) VALUES (?);";
        jdbcTemplate.update(sql, post.getPostMessage());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        post.setPostId(newId);
        return post;
    }

    @Override
    public List<Post> findByPostId(int postId) {
        final String sql = "SELECT postId, userId, postMessage, postTime FROM Post WHERE PostId = ?;";
        return jdbcTemplate.query(sql, new PostMapper(), postId);
    }

    private static final class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int index) throws SQLException {

            LocalDateTime timestamp = rs.getTimestamp("postTime").toLocalDateTime();

            Post p = new Post();
            p.setPostId(rs.getInt("postId"));
            p.setUserId(rs.getInt("userId"));
            p.setPostMessage(rs.getString("postMessage"));
            p.setTimestamp(timestamp);

            return p;
        }
    }

}
