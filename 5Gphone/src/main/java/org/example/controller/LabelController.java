package org.example.controller;

import org.example.common.PageResult;
import org.example.service.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//标签页的控制器
public class LabelController {
    @Resource(name = "PhoneService")
    private PhoneService phoneService;

    @GetMapping("/label")
    public PageResult findPhoneByBrand(
            @RequestParam String brand,
            @RequestParam(defaultValue = "sentiment_score") String order,
            @RequestParam(defaultValue = "1") int pageNum){
        int pageSize = 10;
       // System.out.println(order);
        return phoneService.findPhoneByBrand(brand, order, pageNum, pageSize);
    }
}
