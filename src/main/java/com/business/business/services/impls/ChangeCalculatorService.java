package com.business.business.services.impls;

import com.business.business.ChangeRequest;
import com.business.business.ChangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ChangeCalculatorService {

    @Autowired
    private Map<String, Double> currencyRates;

    public ChangeResponse calculateChange(ChangeRequest request) {
        try {
            // Конвертиране на всичко в EUR за по-лесно изчисление
            Double priceInEur = convertToEur(request.getPrice(), request.getPriceCurrency());
            Double givenInEur = convertToEur(request.getGiven(), request.getGivenCurrency());

            // Проверка дали дадената сума е достатъчна
            if (givenInEur < priceInEur) {
                return new ChangeResponse(
                        0.0,
                        request.getChangeCurrency(),
                        "Дадената сума е по-малка от цената!",
                        false
                );
            }

            // Изчисляване на ресто в EUR
            Double changeInEur = givenInEur - priceInEur;

            // Конвертиране на ресто в желаната валута
            Double changeAmount = convertFromEur(changeInEur, request.getChangeCurrency());

            // Закръгляне до 2 знака след десетичната запетая
            changeAmount = Math.round(changeAmount * 100.0) / 100.0;

            return new ChangeResponse(
                    changeAmount,
                    request.getChangeCurrency(),
                    "Успешно изчислено ресто",
                    true
            );

        } catch (Exception e) {
            return new ChangeResponse(
                    0.0,
                    request.getChangeCurrency(),
                    "Грешка при изчисление: " + e.getMessage(),
                    false
            );
        }
    }

    private Double convertToEur(Double amount, String currency) {
        if (amount == null) return 0.0;

        switch (currency.toUpperCase()) {
            case "EUR":
                return amount;
            case "BGN":
                return amount * currencyRates.get("BGN_TO_EUR");
            default:
                throw new IllegalArgumentException("Неподдържана валута: " + currency);
        }
    }

    private Double convertFromEur(Double amountInEur, String targetCurrency) {
        if (amountInEur == null) return 0.0;

        switch (targetCurrency.toUpperCase()) {
            case "EUR":
                return amountInEur;
            case "BGN":
                return amountInEur * currencyRates.get("EUR_TO_BGN");
            default:
                throw new IllegalArgumentException("Неподдържана валута: " + targetCurrency);
        }
    }
}
