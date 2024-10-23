package ru.bigdecimal_2.service;

import org.springframework.stereotype.Service;
import ru.bigdecimal_2.model.CurrencyTypes;

@Service
public class CurrencyService {
    public void convertInUsd(double amount, CurrencyTypes currency) {
        double amountUsd = amount * currency.getValue();
    }
}
