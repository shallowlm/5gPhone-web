package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.User;

public interface UserService {

    //创建新的用户
    int insertUser(User user);

    //修改用户密码
    int updatePassword(User user);

    //获取用户密码
    String getPassword(String username);


}
