package com.teachmeskills.visaction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Visa {

    BUSINESS(200),
    STUDENT(20),
    SPORT(150),
    TRAVEL(60),
    WORK(85);

    private final int code;
}
