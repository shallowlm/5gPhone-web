package org.example.test;


import org.example.common.PageResult;
import org.example.entity.Phone;
import org.example.common.PhonePageResult;
import org.example.service.PhoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-service.xml",
        "classpath:application-dao.xml"})
public class PhoneServiceTest {
    @Resource(name = "PhoneService")
    private PhoneService phoneService;

    @Test
    public void getAllPhones(){
        PageResult page1=
                phoneService.getAllPhones("goods_price_desc",1,10);
        PageResult page2=
                phoneService.getAllPhones("goods_price_asc",1,10);
        PageResult page3=
                phoneService.getAllPhones("good_count",1,10);
        PageResult page4=
                phoneService.getAllPhones("sentiment_score",1,10);
        PageResult page5=
                phoneService.getAllPhones("comment_count",1,10);
        PageResult page6=
                phoneService.getAllPhones("xx",1,10);
        System.out.println("page1:"+page1);
        System.out.println("page2:"+page2);
        System.out.println("page3:"+page3);
        System.out.println("page4:"+page4);
        System.out.println("page5:"+page5);
        System.out.println("page6:"+page6);

    }
    @Test
    public void findPhoneByTitle(){
        PageResult page1=
                phoneService.findPhoneByTitle("SAMSUNG","goods_price_desc",1,10);
        PageResult page2=
                phoneService.findPhoneByTitle("SAMSUNG","goods_price_asc",1,10);
        PageResult page3=
                phoneService.findPhoneByTitle("SAMSUNG","goods_price",1,10);
        PageResult page4=
                phoneService.findPhoneByTitle("SAMSUNG","sentiment_score",1,10);
        PageResult page5=
                phoneService.findPhoneByTitle("SAMSUNG","goods_price",1,10);
        PageResult page6=
                phoneService.findPhoneByTitle("xxxxxxxx","comment_count",1,10);
        PageResult page7=
                phoneService.findPhoneByTitle("SAMSUNG","xx",1,10);
        System.out.println("page1"+page1);
        System.out.println("page2"+page2);
        System.out.println("page3"+page3);
        System.out.println("page4"+page4);
        System.out.println("page5"+page5);
        System.out.println("page6"+page6);
        System.out.println("page7"+page7);

    }
    @Test
    public void findPhoneByBrand(){
        PageResult page1=
                phoneService.findPhoneByBrand("SAMSUNG","goods_price_desc",1,10);
        PageResult page2=
                phoneService.findPhoneByBrand("SAMSUNG","goods_price_asc",1,10);
        PageResult page3=
                phoneService.findPhoneByBrand("SAMSUNG","goods_price",1,10);
        PageResult page4=
                phoneService.findPhoneByBrand("SAMSUNG","sentiment_score",1,10);
        PageResult page5=
                phoneService.findPhoneByBrand("SAMSUNG","goods_price",1,10);
        PageResult page6=
                phoneService.findPhoneByBrand("xxxxxxxx","comment_count",1,10);
        PageResult page7=
                phoneService.findPhoneByBrand("SAMSUNG","xx",1,10);
        System.out.println("page1"+page1);
        System.out.println("page2"+page2);
        System.out.println("page3"+page3);
        System.out.println("page4"+page4);
        System.out.println("page5"+page5);
        System.out.println("page6"+page6);
        System.out.println("page7"+page7);
    }

    @Test
    public void getCollections(){
        PageResult page1=
                phoneService.getCollections("test",1,10);
        PageResult page2=
                phoneService.getCollections("xx",1,10);
        System.out.println("page1:"+page1);
        System.out.println("page2:"+page2);
    }

    @Test
    public void getPhoneInfoById(){
        Phone phone1= phoneService.getPhoneInfoById(1);
        Phone phone2= phoneService.getPhoneInfoById(6000);
        System.out.println("phone1:"+phone1);
        System.out.println("phone2:"+phone2);
    }

}
