package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.dao.CommentMapper;
import org.example.dao.PhoneMapper;
import org.example.entity.Comment;
import org.example.common.CommentPageResult;
import org.example.entity.Phone;
import org.example.entity.User;
import org.example.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Resource(name = "CommentMapper")
    private CommentMapper commentMapper;

    @Resource(name = "PhoneMapper")
    private PhoneMapper phoneMapper;

    public CommentPageResult
    getAllComments(Integer phone_id, int pageNum, int pageSize, User user){
        PageHelper.startPage(pageNum,pageSize);
        Page<Comment> page=commentMapper.getAllComments(phone_id);
        Boolean searchResult;
        if(user!=null) {
            searchResult = user.getPhonesMap().get(phone_id);
            if(searchResult==null){
                searchResult = false;
            }
        }else {
            searchResult = false; // 如果没有登录，则不显示
        }
        Phone phone=phoneMapper.getPhoneInfoById(phone_id);
        return new CommentPageResult(page.getTotal(),page.getResult(),
                searchResult,phone);
    }

    public CommentPageResult
    getGoodComments(Integer phone_id, int pageNum, int pageSize, User user){
        PageHelper.startPage(pageNum,pageSize);
        Page<Comment> page=commentMapper.getGoodComments(phone_id);
        Boolean searchResult;
        if(user!=null) {
            searchResult = user.getPhonesMap().get(phone_id);
            if(searchResult==null){
                searchResult = false;
            }
        }else {
            searchResult = false; // 如果没有登录，则不显示
        }
        Phone phone=phoneMapper.getPhoneInfoById(phone_id);
        return new CommentPageResult(page.getTotal(),page.getResult(),
                searchResult,phone);
    }

    public CommentPageResult
    getGeneralComments(Integer phone_id, int pageNum, int pageSize, User user){
        PageHelper.startPage(pageNum,pageSize);
        Page<Comment> page=commentMapper.getGeneralComments(phone_id);
        Boolean searchResult;
        if(user!=null) {
            searchResult = user.getPhonesMap().get(phone_id);
            if(searchResult==null){
                searchResult = false;
            }
        }else {
            searchResult = false; // 如果没有登录，则不显示
        }
        Phone phone=phoneMapper.getPhoneInfoById(phone_id);
        return new CommentPageResult(page.getTotal(),page.getResult(),
                searchResult,phone);
    }

    public CommentPageResult
    getPoorComments(Integer phone_id, int pageNum, int pageSize, User user){
        PageHelper.startPage(pageNum,pageSize);
        Page<Comment> page=commentMapper.getPoorComments(phone_id);
        Boolean searchResult;
        if(user!=null) {
            searchResult = user.getPhonesMap().get(phone_id);
            if(searchResult==null){
                searchResult = false;
            }
        }else {
            searchResult = false; // 如果没有登录，则不显示
        }
        Phone phone=phoneMapper.getPhoneInfoById(phone_id);
        return new CommentPageResult(page.getTotal(),page.getResult(),
                searchResult,phone);
    }
}
