package org.example.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.example.entity.Phone;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("PhoneMapper")
public interface PhoneMapper {

    @Select("select * from goods order by goods_price desc")
    @Results(id="phoneMap",value = {
            @Result(id=true,column = "goods_id",property = "phone_id"),
            @Result(column = "goods_title",property = "phone_title"),
            @Result(column =  "goods_price",property = "phone_price"),
            @Result(column = "goods_url",property = "phone_url"),
            @Result(column = "goods_brand",property = "phone_brand"),
            @Result(column = "goods_model",property = "phone_model"),
            @Result(column = "goods_picture",property = "phone_picture"),
            @Result(column = "comment_count",property = "comment_count"),
            @Result(column = "good_count",property = "good_count"),
            @Result(column = "general_count",property = "general_count"),
            @Result(column = "poor_count",property = "poor_count"),
            @Result(column = "sentiment_score",property = "sentiment_score"),
            @Result(column = "wordle",property = "wordle")
    })
    //获得全部的手机,并根据价格降序排序
    Page<Phone> getAllPhonesSortedByPriceDesc();

    @Select("select * from goods order by goods_price")
    @ResultMap("phoneMap")
    //获得全部的手机,并根据价格升序排序
    Page<Phone> getAllPhonesSortedByPriceAsc();

    @Select("select * from goods order by good_count desc")
    @ResultMap("phoneMap")
        //获得全部的手机,并根据好评数排序
    Page<Phone> getAllPhonesSortedByRating();


    @Select("select * from goods order by sentiment_score desc")
    @ResultMap("phoneMap")
    //获得全部的手机,并根据情感得分排序
    Page<Phone> getAllPhonesSortedBySentimentScore();

    @Select("select * from goods order by comment_count desc")
    @ResultMap("phoneMap")
        //获得全部的手机,并根据评论数排序
    Page<Phone> getAllPhonesSortedByCommentCount();

    @Select("select * from goods where goods_title like concat('%',#{title},'%') " +
            "order by goods_price desc")
    @ResultMap("phoneMap")
    //根据标题查找手机,并按价格降序排序
    Page<Phone>
    findPhoneByTitleSortedByPriceDesc(@Param("title") String title);

    @Select("select * from goods where goods_title like concat('%',#{title},'%') " +
            "order by goods_price")
    @ResultMap("phoneMap")
    //根据标题查找手机,并按价格升序排序
    Page<Phone>
    findPhoneByTitleSortedByPriceAsc(@Param("title") String title);

    @Select("select * from goods where goods_title like concat('%',#{title},'%') " +
            "order by good_count desc")
    @ResultMap("phoneMap")
    //根据标题查找手机,并按好评数排序
    Page<Phone>
    findPhoneByTitleSortedByRating(@Param("title") String title);

    @Select("select * from goods where goods_title like concat('%',#{title},'%') " +
            "order by sentiment_score desc")
    @ResultMap("phoneMap")
    //根据标题查找手机,并按情感得分排序
    Page<Phone>
    findPhoneByTitleSortedBySentimentScore(@Param("title") String title);

    @Select("select * from goods where goods_title like concat('%',#{title},'%') " +
            "order by comment_count desc")
    @ResultMap("phoneMap")
    //根据标题查找手机,并按评论数排序
    Page<Phone>
    findPhoneByTitleSortedByCommentCount(@Param("title") String title);


    @Select("select  * from goods where goods_brand like concat('%',#{brand},'%')" +
            "order by goods_price desc")
    @ResultMap("phoneMap")
    //根据品牌查找手机,并根据价格降序排序
    Page<Phone>
    findPhoneByBrandSortedByPriceDesc(@Param("brand") String brand);

    @Select("select  * from goods where goods_brand like concat('%',#{brand},'%')" +
            "order by goods_price")
    @ResultMap("phoneMap")
    //根据品牌查找手机,并根据价格升序排序
    Page<Phone>
    findPhoneByBrandSortedByPriceAsc(@Param("brand") String brand);
    @Select("select  * from goods where goods_brand like concat('%',#{brand},'%')" +
            "order by good_count desc")
    @ResultMap("phoneMap")
    //根据品牌查找手机，并根据好评数排序
    Page<Phone>
    findPhoneByBrandSortedByRating(@Param("brand") String brand);

    @Select("select  * from goods where goods_brand like concat('%',#{brand},'%')" +
            "order by sentiment_score desc")
    @ResultMap("phoneMap")
    //根据品牌查找手机，并根据情感得分排序
    Page<Phone>
    findPhoneByBrandSortedBySentimentScore(@Param("brand") String brand);

    @Select("select  * from goods where goods_brand like concat('%',#{brand},'%')" +
            "order by comment_count desc")
    @ResultMap("phoneMap")
    //根据品牌查找手机，并根据评论数量排序
    Page<Phone>
    findPhoneByBrandSortedByCommentCount(@Param("brand") String brand);

    @Select("select * from goods where goods_id in " +
            "(select goods_id from collections where username=#{username})")
    @ResultMap("phoneMap")
    //按页查找用户收藏的手机
    Page<Phone> getCollections(@Param("username") String username);

    @Select("select * from goods where goods_id=#{phone_id}")
            @ResultMap("phoneMap")
    //通过手机id获取单个手机的信息
    Phone getPhoneInfoById(@Param("phone_id") Integer phone_id);
}
