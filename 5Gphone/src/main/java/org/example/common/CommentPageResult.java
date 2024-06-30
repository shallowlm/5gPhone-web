package org.example.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.common.PageResult;
import org.example.entity.Phone;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class CommentPageResult extends PageResult implements java.io.Serializable{
    private boolean collection;//记录这个手机是否在该用户的收藏表中
    private Phone phone;//手机的详细信息

    public CommentPageResult(long pages, List rows,boolean collection,Phone phone){
        super(pages, rows);
        this.collection=collection;
        this.phone=phone;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"collection="+collection;
    }
}
