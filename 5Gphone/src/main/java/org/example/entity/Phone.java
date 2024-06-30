package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component("phone")
public class Phone {
    private Integer phone_id;
    private String phone_title;
    private String phone_url;
    private float phone_price;
    private String phone_brand;
    private String phone_model;
    private String phone_picture;
    private Integer comment_count;
    private Integer good_count;
    private Integer general_count;
    private Integer poor_count;
    private double sentiment_score;
    private String wordle;
}
