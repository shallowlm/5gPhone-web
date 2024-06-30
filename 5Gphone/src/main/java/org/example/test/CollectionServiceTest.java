package org.example.test;

import org.example.service.CollectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-service.xml",
        "classpath:application-dao.xml"})
public class CollectionServiceTest {

    @Resource(name = "CollectionService")
    private CollectionService collectionService;

    @Test
    public void insertCollection(){
        int result1=collectionService.insertCollection("test",2);
        int result2=collectionService.insertCollection("test",1);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
    }

    @Test
    public void delectCollection() {
        int result1=collectionService.deleteCollection("test",1);
        int result2=collectionService.deleteCollection("test",4);
        int result3=collectionService.deleteCollection("test2",1);
        int result4=collectionService.deleteCollection("test2",4);
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);
        System.out.println("result3:"+result3);
        System.out.println("result4:"+result4);

    }

    @Test
    public void getCollectionToUser() {
        List<Integer> result1=collectionService.getCollectionToUser("test");
        List<Integer> result2=collectionService.getCollectionToUser("test2");
        System.out.println("result1:"+result1);
        System.out.println("result2:"+result2);

    }
}
