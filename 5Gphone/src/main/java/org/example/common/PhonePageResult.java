package org.example.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.example.common.PageResult;

import java.util.Date;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
//给需要返回爬虫时间的首页专门创建的类
public class PhonePageResult extends PageResult implements java.io.Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' Time: 'HH:mm:ss.SSSZ")
    private Date crawl_time;//上一次爬虫的时间

    public PhonePageResult(long pages,List rows,Date crawl_time){
        super(pages, rows);
        this.crawl_time = crawl_time;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"crawl_time="+crawl_time;
    }
}
