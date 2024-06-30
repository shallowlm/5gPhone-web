package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository("CrawlMapper")
public interface CrawlMapper {
    @Select("select crawl_time from crawl")
    Date getCrawlTime();
}
