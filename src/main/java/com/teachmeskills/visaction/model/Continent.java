package com.teachmeskills.visaction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Continent {

    ASIA(20),
    AFRICA(40),
    EUROPE(60),
    AMERICA(80),
    OCEANIA(100);

    private final int code;
}
