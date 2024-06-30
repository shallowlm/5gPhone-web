package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("CollectionMapper")
public interface CollectionMapper {

    @Insert("insert into collections values (#{username},#{phone_id})")
    //添加用户的收藏
    int insertCollection
    (@Param("username") String username, @Param("phone_id") Integer phone_id);

    @Delete("delete from collections where " +
            "username = #{username} and goods_id = #{phone_id}")
    //删除用户的一个收藏
    int deleteCollection
    (@Param("username") String username, @Param("phone_id") Integer phone_id);

    @Select("select goods_id from collections where username = #{username}")
    @Results(value = {
            @Result(id=true,column = "goods_id",property = "phone_id")})
    //取出用户收藏的全部手机的id
    List<Integer> getCollectionToUser(@Param("username") String username);
}
