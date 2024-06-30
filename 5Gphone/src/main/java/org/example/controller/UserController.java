package org.example.controller;

import org.example.common.Result;
import org.example.common.PageResult;
import org.example.entity.User;
import org.example.service.CollectionService;
import org.example.service.PhoneService;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource(name = "UserService")
    private UserService userService;

    @Resource(name = "CollectionService")
    private CollectionService collectionService;

    @Resource(name = "PhoneService")
    private PhoneService phoneService;

    @PostMapping("/register")
    public Result<?> register(@RequestParam String username,
                           @RequestParam String pwd1,
                           @RequestParam String pwd2){
        boolean checkPwd;
        checkPwd=pwd1.equals(pwd2);
        if(!checkPwd){
            return Result.error(-2,"两次输入的密码不一样。");
        }
        User user=new User(username,pwd1);
        int checkUsername=userService.insertUser(user);
        if(checkUsername==0){
            return Result.error(-2,"该用户名已存在，请重新输入。");
        }
        return Result.success();
    }

    @PostMapping("/login")
    public Result<?> login(@RequestParam String username,
                        @RequestParam String pwd,
                        HttpServletRequest request){
        String TruePwd=userService.getPassword(username);
        if(TruePwd==null){
            return Result.error(-2,"该用户不存在，请先注册。");
        }
        if(!TruePwd.equals(pwd)){
            return Result.error(-2,"密码错误，请重新输入。");
        }
        //登录成功，初始化User对象
        User user=new User(username,pwd);
        user.setPhones(collectionService.getCollectionToUser(username));
        user.PhonesToPhonesMap();
        HttpSession session= request.getSession(true);
        session.setAttribute("user",user);
        return Result.success();
    }

    @GetMapping("/logout")
    public Result<?> logout(HttpServletRequest request){
        HttpSession session= request.getSession(false);
        if(session==null){
            return Result.success();
        }
        session.invalidate();
        return Result.success();
    }

    @GetMapping("favlist")
    public Result<?> favlist(@RequestParam (defaultValue = "1") int pageNum
            ,HttpServletRequest request){
        HttpSession session= request.getSession(false);
        if(session==null){
            return Result.error(-1,"登录超时，请重新登录");
        }
        User user=(User) session.getAttribute("user");
        int pageSize=10;
        PageResult pageResult=phoneService.getCollections
                (user.getUsername(),pageNum,pageSize);
        return Result.success(pageResult);
    }

    @PostMapping("/change_password")
    public Result<?> ChangePassword(@RequestParam String pwd1,
                                 @RequestParam String pwd2,
                                 @RequestParam String pwd3,
                                 HttpServletRequest request){
        HttpSession session= request.getSession(false);
        if(session==null){
            return Result.error(-1,"登录超时，请重新登录");
        }
        User user=(User) session.getAttribute("user");
        if(user.getPassword().equals(pwd1)){
            if(pwd2.equals(pwd3)){
                user.setPassword(pwd2);
                userService.updatePassword(user);
                return Result.success();
            }
            else return Result.error(-2,"两次输入的新密码不一致");
        }
        else return Result.error(-2,"原密码错误");
    }


}
