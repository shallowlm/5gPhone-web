package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component("user")
public class User {
    private String username;
    private String password;
    //在用户登录时将数据库内容载入到list中
    private List<Integer> phones;
    //将list变成map，这样之后查找该用户的收藏可以通过map在单位时间内找到而不用在list内查找
    //不过这样设置需要在用户添加或删除收藏时同时修改map和数据库
    private Map<Integer,Boolean> phonesMap;

    public User(String username,String password){
        this.username=username;
        this.password=password;
        this.phones=null;
        this.phonesMap=null;
    }

    //把List<Integer> phones转换成Map<Integer,Boolean> phonesMap
    //在用户登录时调用
    public void PhonesToPhonesMap(){
        this.phonesMap=this.phones.stream()
                .collect(Collectors.toMap(Function.identity(), k -> true));
    }

}
