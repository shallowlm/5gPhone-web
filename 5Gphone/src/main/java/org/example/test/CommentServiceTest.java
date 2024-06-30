package org.example.test;

import org.example.common.CommentPageResult;
import org.example.common.PageResult;
import org.example.entity.User;
import org.example.service.CollectionService;
import org.example.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-service.xml",
        "classpath:application-dao.xml"})
public class CommentServiceTest {
    @Resource(name = "CommentService")
    private CommentService commentService;

    @Resource(name = "CollectionService")
    private CollectionService collectionService;

    @Test
    public void getAllComments(){
        User user=new User("test","123");
        user.setPhones(collectionService.getCollectionToUser(user.getUsername()));
        user.PhonesToPhonesMap();
        PageResult result1=commentService.getAllComments(1,1,10,null);
        PageResult result2=commentService.getAllComments(1,1,10,user);
        PageResult result3=commentService.getAllComments(2,1,10,user);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
        System.out.println("result3:"+result3);

    }

    @Test
    public void getGoodComments(){
        User user=new User("test","123");
        user.setPhones(collectionService.getCollectionToUser(user.getUsername()));
        user.PhonesToPhonesMap();
        PageResult result1=commentService.getGoodComments(1,1,10,null);
        PageResult result2=commentService.getGoodComments(1,1,10,user);
        PageResult result3=commentService.getGoodComments(2,1,10,user);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
        System.out.println("result3:"+result3);
    }

    @Test
    public void getGeneralComments(){
        User user=new User("test","123");
        user.setPhones(collectionService.getCollectionToUser(user.getUsername()));
        user.PhonesToPhonesMap();
        PageResult result1=commentService.getGeneralComments(1,1,10,null);
        PageResult result2=commentService.getGeneralComments(1,1,10,user);
        PageResult result3=commentService.getGeneralComments(2,1,10,user);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
        System.out.println("result3:"+result3);
    }

    @Test
    public void getPoorComments(){
        User user=new User("test","123");
        user.setPhones(collectionService.getCollectionToUser(user.getUsername()));
        user.PhonesToPhonesMap();
        PageResult result1=commentService.getPoorComments(1,1,10,null);
        PageResult result2=commentService.getPoorComments(1,1,10,user);
        PageResult result3=commentService.getPoorComments(2,1,10,user);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
        System.out.println("result3:"+result3);
    }
}
