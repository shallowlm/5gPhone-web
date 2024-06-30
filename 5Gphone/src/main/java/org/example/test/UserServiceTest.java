package org.example.test;

import org.example.entity.User;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-service.xml",
        "classpath:application-dao.xml"})
public class UserServiceTest {

    @Resource(name="UserService")
    private UserService userService;
    @Test
    public void getPassword(){
        String pwd1=userService.getPassword("test");
        String pwd2=userService.getPassword("test3");
        System.out.println("pwd1:"+pwd1);
        System.out.println("pwd2:"+pwd2);
    }

    @Test
    public void insertUser(){
        User user1=new User("test2","123");
        User user2=new User("test","123");
        int result1=userService.insertUser(user1);
        int result2=userService.insertUser(user2);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
    }

    @Test
    public void updatePassword(){
        User user1=new User("test","321");
        User user2=new User("test3","123");
        int result1=userService.updatePassword(user1);
        int result2=userService.updatePassword(user2);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
    }

}
