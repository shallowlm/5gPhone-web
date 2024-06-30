package org.example.controller;

import org.example.common.PageResult;
import org.example.common.PhonePageResult;
import org.example.service.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//主页的控制器
public class MainController {

    @Resource(name = "PhoneService")
    private PhoneService phoneService;

    @GetMapping("")
    public PageResult getAllPhones
            (@RequestParam(defaultValue ="sentiment_score") String order,
             @RequestParam(defaultValue = "1") int pageNum){
        int pageSize = 10;
//        System.out.println("这里是main controller");
//        System.out.println(phoneService.getAllPhones(order,pageNum,pageSize));
        return phoneService.getAllPhones(order,pageNum,pageSize);
    }
}
