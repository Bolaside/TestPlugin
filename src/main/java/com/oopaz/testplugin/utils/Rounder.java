package com.oopaz.testplugin.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounder {
    public static double round(double number, int scale) {
        if (scale < 0) throw new IllegalArgumentException("Round scale cannot be less than 0");

        return new BigDecimal(Double.toString(number))
                .setScale(scale, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
