package com.business.business.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;
import java.util.HashMap;

@Configuration
public class CurrencyConfig {

    @Bean
    public Map<String, Double> currencyRates() {
        Map<String, Double> rates = new HashMap<>();
        rates.put("EUR_TO_BGN", 1.95583);
        rates.put("BGN_TO_EUR", 1.0 / 1.95583);
        return rates;
    }
}
