package ru.bigdecimal_2.service;

import org.springframework.stereotype.Service;
import ru.bigdecimal_2.model.CurrencyTypes;

import java.text.DecimalFormat;

@Service
public class CurrencyService {
    public double convertInUsd(double amount, CurrencyTypes currency) {
        double amountUsd = amount * currency.getValue();
        DecimalFormat df = new DecimalFormat("#.#####");
        String roundedNumber = df.format(amountUsd);
        return Double.parseDouble(roundedNumber);
    }
}
