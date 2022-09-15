package com.example.study.java8.optional;

import lombok.Data;

import java.util.Optional;

@Data
public class Cat {
    private Optional<Eat> eat;
}
