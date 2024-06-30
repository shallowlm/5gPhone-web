package org.example.controller;

import org.example.common.PageResult;
import org.example.service.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SearchController {
    @Resource(name = "PhoneService")
    private PhoneService phoneService;

    @GetMapping("/search")
    public PageResult findPhoneByTitle(
            @RequestParam String query,
            @RequestParam(defaultValue = "sentiment_score") String order,
            @RequestParam(defaultValue = "1") int pageNum) {
        int pageSize=10;
        return phoneService.findPhoneByTitle(query,order,pageNum,pageSize);
    }
}
