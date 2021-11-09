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


    /**
     * 使用事务处理，多个改变数据的操作
     * @param user1
     * @param user2
     * @return
     */
    public int addUsers(User user1,User user2);


    /**
     * 记载日志信息，日志信息可以放在你所需要的地方（service,controller)
     * @param user1
     * @param user2
     */
    public void addUsersLog(User user1,User user2);

}
