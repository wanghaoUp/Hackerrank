package com.scu.hub.mapper;

import com.scu.hub.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `user`")
    public List<User> getAllUser();

    @Select("SELECT * FROM `user` WHERE user_id = #{id}")
    public User getUserById(@Param("id")String id);

    @Select("SELECT * FROM `user` WHERE username = #{username}")
    public List<User> getUserByName(@Param("username")String username);

    @Insert("INSERT into `user`(user_id,username,`password`) " +
            "VALUES (#{userId},#{username},#{password})")
    public Integer insertUser(@Param("userId")String userId,
                             @Param("username")String username,
                             @Param("password")String password);


    @Update("UPDATE `user` SET username = #{username} WHERE  user_id=#{userId}")
    public Integer updateUserName(@Param("username")String username,
                                  @Param("userId")String userId);
}
