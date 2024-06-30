package org.example.dao;
import org.apache.ibatis.annotations.*;
import org.example.entity.User;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("UserMapper")
public interface UserMapper {

    @Insert("insert into users values (#{username},#{password}) ")
    //创建新用户
    int insertUser(User user);

    @Update("update users set password = #{password} where username = #{username}")
    //修改密码
    int updatePassword(User user);

    @Select("select password from users where username = #{username}")
    //获取用户密码
    String getPassword(@Param("username") String username);
}
