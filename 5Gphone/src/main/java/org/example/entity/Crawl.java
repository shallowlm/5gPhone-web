package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component("crawl")
public class Crawl {
    private Date crawl_time;
}
