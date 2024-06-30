package org.example.common;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class PageResult {
    private long pages;//一共有多少页
    private List rows;//数据库返回的数据集
    public PageResult(long pages,List rows){
        super();
        this.pages = pages;
        this.rows = rows;
    }
}
