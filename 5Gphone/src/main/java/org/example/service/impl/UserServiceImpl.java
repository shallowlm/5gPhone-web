package org.example.service.impl;

import org.example.dao.UserMapper;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service("UserService")
public class UserServiceImpl  implements UserService {
    @Resource(name="UserMapper")
    private UserMapper userMapper;
    public int insertUser(User user){
        try {
            return userMapper.insertUser(user);
        }
        catch (Exception e) {
            if (e.getMessage().contains("Duplicate entry")) {
                return 0;
            }
            throw e;
        }
    }


    public int updatePassword(User user){
        return userMapper.updatePassword(user);
    }

    public String getPassword(String username){
        return userMapper.getPassword(username);
    }

}
