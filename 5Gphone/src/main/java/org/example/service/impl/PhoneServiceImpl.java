package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.dao.CrawlMapper;
import org.example.dao.PhoneMapper;
import org.example.common.PageResult;
import org.example.common.PhonePageResult;
import org.example.entity.Phone;
import org.example.service.PhoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("PhoneService")
public class PhoneServiceImpl implements PhoneService {
    @Resource(name= "PhoneMapper")
    private PhoneMapper phoneMapper;

    @Resource(name = "CrawlMapper")
    private CrawlMapper crawlMapper;
    public PhonePageResult getAllPhones(String order, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<Phone> page;
        switch (order){
            case "goods_price_desc":
                page = phoneMapper.getAllPhonesSortedByPriceDesc();
                break;
            case "goods_price_asc":
                page = phoneMapper.getAllPhonesSortedByPriceAsc();
                break;
            case "good_count":
                page = phoneMapper.getAllPhonesSortedByRating();
                break;
            case "sentiment_score":
                page=phoneMapper.getAllPhonesSortedBySentimentScore();
                break;
            case "comment_count":
                page= phoneMapper.getAllPhonesSortedByCommentCount();
                break;
            default:
                page=phoneMapper.getAllPhonesSortedBySentimentScore();
        }
        Date crawlTime=crawlMapper.getCrawlTime();
        return new PhonePageResult(page.getTotal(),page.getResult(),crawlTime);
    }

    public PageResult
    findPhoneByTitle(String query, String order, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<Phone> page;
        switch (order){
            case "goods_price_desc":
                page =phoneMapper.findPhoneByTitleSortedByPriceDesc(query);
                break;
            case "goods_price_asc":
                page =phoneMapper.findPhoneByTitleSortedByPriceAsc(query);
                break;
            case "good_count":
                page = phoneMapper.findPhoneByTitleSortedByRating(query);
                break;
            case "sentiment_score":
                page=phoneMapper.findPhoneByTitleSortedBySentimentScore(query);
                break;
            case "comment_count":
                page= phoneMapper.findPhoneByTitleSortedByCommentCount(query);
                break;
            default:
                page=phoneMapper.findPhoneByTitleSortedBySentimentScore(query);
        }
        return new PageResult(page.getTotal(),page.getResult());
    }

    public PageResult
    findPhoneByBrand(String brand, String order,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<Phone> page;
        switch (order) {
            case "goods_price_desc":
                page = phoneMapper.findPhoneByBrandSortedByPriceDesc(brand);
                break;
            case "goods_price_asc":
                page = phoneMapper.findPhoneByBrandSortedByPriceAsc(brand);
                break;
            case "good_count":
                page = phoneMapper.findPhoneByBrandSortedByRating(brand);
                break;
            case "sentiment_score":
                page=phoneMapper.findPhoneByBrandSortedBySentimentScore(brand);
                break;
            case "comment_count":
                page= phoneMapper.findPhoneByBrandSortedByCommentCount(brand);
                break;
            default:
                page=phoneMapper.findPhoneByBrandSortedBySentimentScore(brand);
        }
        return new PageResult(page.getTotal(),page.getResult());
    }

    public PageResult
    getCollections(String username,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<Phone> page=phoneMapper.getCollections(username);
        return new PageResult(page.getTotal(),page.getResult());
    }


    public Phone getPhoneInfoById(Integer phone_id){
        return phoneMapper.getPhoneInfoById(phone_id);
    }
}
