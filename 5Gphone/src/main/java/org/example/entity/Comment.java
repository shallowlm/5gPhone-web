package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component("comment")
public class Comment {
    private Integer comment_id;
    private Integer phone_id;
    private String content;
    private Date creation_time;
    private Integer label;
}
