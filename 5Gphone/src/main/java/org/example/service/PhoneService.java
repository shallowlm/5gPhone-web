package org.example.service;

import org.example.common.PageResult;
import org.example.entity.Phone;
import org.example.common.PhonePageResult;

import java.util.List;

public interface PhoneService {

    //分页查询，获得全部的手机和爬虫时间
    PhonePageResult getAllPhones(String order, int pageNum, int pageSize);

    //分页查询，根据输入的query查找手机
    PageResult
    findPhoneByTitle(String query, String order, int pageNum, int pageSize);

    //分页查询，根据输入的brand查找手机
    PageResult
    findPhoneByBrand(String brand, String order,int pageNum, int pageSize);

    //分页查询，获取用户的收藏列表
    PageResult getCollections(String username,int pageNum, int pageSize);


    //通过id获取单个手机的信息
    Phone getPhoneInfoById(Integer phone_id);
}
