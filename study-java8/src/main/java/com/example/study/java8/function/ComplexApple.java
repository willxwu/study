package com.example.study.java8.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 多个参数，构造方法推导
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComplexApple {
    private String color;
    private Integer weight;
    private String name;
}
