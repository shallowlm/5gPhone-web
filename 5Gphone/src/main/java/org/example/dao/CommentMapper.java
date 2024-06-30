package org.example.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.example.entity.Comment;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("CommentMapper")
public interface CommentMapper {

    @Select("select * from comments where goods_id=#{phone_id}")
    @Results(id = "commentMap",value = {
            @Result(column = "comments_id", property = "comment_id"),
            @Result(column = "content", property = "content"),
            @Result(column = "goods_id", property = "phone_id"),
            @Result(column = "creation_time", property = "creation_time"),
            @Result(column = "label", property = "label")
    })
    //获取指定手机的全部评价
    Page<Comment> getAllComments(@Param("phone_id") Integer phone_id);

    @Select("select * from comments where goods_id=#{phone_id} and " +
            "(label=4 or label=5)")
    @ResultMap("commentMap")
    //获取指定手机的好评
    Page<Comment> getGoodComments(@Param("phone_id") Integer phone_id);

    @Select("select * from comments where goods_id=#{phone_id} and label=3")
    @ResultMap("commentMap")
    //获取指定手机的中评
    Page<Comment> getGeneralComments(@Param("phone_id") Integer phone_id);

    @Select("select * from comments where goods_id=#{phone_id} and " +
            "(label=2 or label=1 or label=0)")
    @ResultMap("commentMap")
    //获取指定手机的差评
    Page<Comment> getPoorComments(@Param("phone_id") Integer phone_id);
}
