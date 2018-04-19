package com.ding.consumer.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by ding on 2018/4/17.
 */
@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}
