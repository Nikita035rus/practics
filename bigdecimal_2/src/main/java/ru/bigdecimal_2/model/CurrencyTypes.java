package ru.bigdecimal_2.model;

import lombok.Getter;

@Getter
public enum CurrencyTypes {
    RUB (0.010353), USD(1), EUR(1.0774), GBP(1.2953);
    private final double value;

    CurrencyTypes(double value) {
        this.value = value;
    }

}
