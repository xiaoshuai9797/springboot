package com.pctc.dao;

import com.pctc.model.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    public int insert(@Param("name") String name, @Param("age") Integer age);


    @Select("SELECT * FROM USER WHERE id = #{id}")
    public User findById(@Param("id") Integer id);


    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    public int updateUser(User user);



    @Delete("delete from user where id=#{id}")
    public int deleteUser(int id);
}
