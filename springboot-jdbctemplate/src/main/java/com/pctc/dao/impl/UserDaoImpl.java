package com.pctc.dao.impl;

import com.pctc.dao.UserDao;
import com.pctc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createUser(User user) {
        String sql = "insert into user(name,age) value(?,?)";
        int count = jdbcTemplate.update(sql,new Object[]{user.getName(),user.getAge()});
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select id,name,age from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(sql,rowMapper);
        return users;
    }

    @Override
    public User getUser(Integer id) {
        String sql = "select id,name,age from user where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql,rowMapper,id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name=?,age=? where id=?";
        int count= jdbcTemplate.update(sql, new Object[]{user.getName(),user.getAge(),user.getId()});
    }

    @Override
    public void deleteUser(Integer id) {
        String sql="delete from user where id=?";
        int count= jdbcTemplate.update(sql, new Object[]{id});
    }
}
