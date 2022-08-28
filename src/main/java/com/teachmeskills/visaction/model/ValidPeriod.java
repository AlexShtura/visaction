package com.teachmeskills.visaction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValidPeriod {

    THREE_DAYS(5, "three days"),
    WEEK(8, "week"),
    MONTH(20, "month"),
    SIX_MONTHS(80, "six months"),
    YEAR(120, "year"),
    TWO_YEARS(200, "two years");

    private final int codePrise;
    private final String codeName;
}
