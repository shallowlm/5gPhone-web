package org.example.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//主要用于返回登录信息
public class Result<T> {
    private int code;//0是成功，小于0是失败
    private String msg;//记录失败原因或者成功
    private T data;

    public Result(T data){
        this.data=data;
    }

    public Result(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Result success(){
        return new Result(0,"成功");
    }

    public static <T> Result<T> success(T data){
        return new Result<>(0,"成功",data);
    }

    public static Result error(int code,String msg){
        return new Result(code,msg);
    }
}
