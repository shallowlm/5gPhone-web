package org.example.controller;

import org.example.common.PageResult;
import org.example.entity.Phone;
import org.example.entity.User;
import org.example.service.CommentService;
import org.example.service.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("detail")
public class DetailController {
    @Resource(name = "CommentService")
    private CommentService commentService;

    @Resource(name = "PhoneService")
    private PhoneService phoneService;

    @GetMapping("/comment")
    public PageResult getComment(
            @RequestParam Integer phone_id,
            @RequestParam(defaultValue = "all") String comment,
            @RequestParam(defaultValue = "1") int pageNum,
            HttpServletRequest request){
        int pageSize=10;
        HttpSession session=request.getSession(false);
        User user=null;
        if(session!=null) {
            user = (User) session.getAttribute("user");
        }
        switch (comment){
            case "all":
                return  commentService.getAllComments
                        (phone_id,pageNum,pageSize,user);
            case "good":
                return commentService.getGoodComments
                        (phone_id,pageNum,pageSize,user);
            case "general":
                return commentService.getGeneralComments
                        (phone_id,pageNum,pageSize,user);
            case "poor":
                return commentService.getPoorComments
                        (phone_id,pageNum,pageSize,user);
            default:
                return  commentService.getAllComments
                        (phone_id,pageNum,pageSize,user);
        }
    }

    @GetMapping("/phone")
    public Phone getPhoneInfoById(@RequestParam Integer phone_id){
        return phoneService.getPhoneInfoById(phone_id);
    }
}
