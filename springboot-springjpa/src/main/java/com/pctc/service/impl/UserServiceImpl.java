package com.pctc.service.impl;

import com.pctc.dao.UserDao;
import com.pctc.model.User;
import com.pctc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;


    @Override
    public int addUser(User user) {
        int count=0;
        if (user!=null){
            userDao.save(user);//save方法，先进行ID查找，如果没有对应的信息则添加信息，有对应的信息则修改信息
            count=1;
        }
        return  count;
    }


    @Override
    public int editUser(User user) {
        int count=0;
        if (user!=null){
            userDao.save(user); //save方法，先进行ID查找，如果没有对应的信息则添加信息，有对应的信息则修改信息
            count=1;
        }
        return  count;
    }

    @Override
    public int deleteUser(Integer id) {
        int count = 0;
        if(id!=null){
            userDao.deleteById(id);
            count = 1;
        }
        return count;
    }

    @Override
    @Cacheable(value="usercache")    //value 表示缓存到哪里
    public List<User> findAllUser() {

        List<User> users=userDao.findAll();
        return  users;
    }

    @Override
    public User findUserOne(Integer id) {
        if(id!=null){
            //Optional,不会有空指针的问题
            Optional<User> userOptional = userDao.findById(id);
            if(userOptional.isPresent()){
                User user = userOptional.get();
                return user;
            }
            return null;
        }
        return null;
    }

    @Override
    public List<User> findAllUser(Example example){
        if (example!=null) {
            List<User> users = userDao.findAll(example);
            return users;
        }
        return null;
    }

    @Override
    @Transactional
    public int addUsers(User user1, User user2) {
        int count=0;
        if(user1!=null&&user2!=null){
            userDao.save(user1);
            count++;
/*出现错误，两个都不添加*/
            //模拟出现错误
			/*String s=null;
			s.length();*/

         /*   if (1==1)
                throw new RuntimeException("出现人为控制不了的错误！！！");*/


            userDao.save(user2);
            count++;


            return count;
        }
        return count;
    }

    @Override
    @Transactional
    public void addUsersLog(User user1, User user2) {
     logger.debug(UserServiceImpl.class.getName()+"debug添加用户:"+user1.toString());
        logger.info(UserServiceImpl.class.getName()+" info添加用户：" + user2.toString());

        logger.warn(UserServiceImpl.class.getName()+" warn添加用户：" + user2.toString());

        logger.error(UserServiceImpl.class.getName()+"error错误信息！！！");

        userDao.save(user1);

        String s=null;
        s.length();//报错空指针，在日志文件中查看错误

        userDao.save(user2);
    }


}
