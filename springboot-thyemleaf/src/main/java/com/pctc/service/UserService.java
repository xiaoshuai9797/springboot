package com.pctc.service;

import com.pctc.model.User;
import org.springframework.data.domain.Example;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);


    /**
     * 修改用户
     * @param user
     * @return
     */
    public int editUser(User user);


    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(Integer id);


    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAllUser();



    /**
     * 查询一个用户对象
     * @return
     */
    public User findUserOne(Integer id);




    /**
     * 条件查询所有用户不能模糊查询
     * @param example
     * @return
     */
    public List<User> findAllUser(Example example);



}
