package org.example.controller;

import org.example.common.Result;
import org.example.entity.User;
import org.example.service.CollectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class CollectionController {
    @Resource(name = "CollectionService")
    private CollectionService collectionService;

    @GetMapping("/collect")
    //添加收藏
    public Result<?> collect(@RequestParam Integer phone_id,
                             HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return  Result.error(-1,"登录超时，请重新登录");
        }
        User user=(User) session.getAttribute("user");
        //添加进数据库
        int check=collectionService.insertCollection
                (user.getUsername(),phone_id);
        if(check==0){
            return Result.error(-2,"收藏失败，请稍后再试");
        }
        //修改user的map
        Map<Integer,Boolean> phonesMap=user.getPhonesMap();
        phonesMap.put(phone_id,true);
        return Result.success();
    }

    @GetMapping("/delete_phone")
    //删除收藏
    public Result<?> deleteCollection(@RequestParam Integer phone_id,
                                      HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return  Result.error(-1,"登录超时，请重新登录");
        }
        User user=(User) session.getAttribute("user");
        //删除数据库中的记录
        int check=collectionService.deleteCollection(user.getUsername(),phone_id);
        if(check==0){
            return Result.error(-2,"删除失败，请稍后再试");
        }
        //修改user的map
        Map<Integer,Boolean> phonesMap=user.getPhonesMap();
        phonesMap.remove(phone_id);
        return Result.success();
    }
}
