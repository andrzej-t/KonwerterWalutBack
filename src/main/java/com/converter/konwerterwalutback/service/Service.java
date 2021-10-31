package com.converter.konwerterwalutback.service;

import com.converter.konwerterwalutback.nbp.NbpClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Service {

    @Autowired
    NbpClient nbpClient;

    Double result;

    public Double giveResult(Integer amount, String currencyFrom, String currencyTo) {

        double valueFrom = nbpClient.getAllCurrencies().stream().filter(rates -> rates.getCode().equals(currencyFrom)).findFirst().get().getBid();

        double valueTo = nbpClient.getAllCurrencies().stream().filter(rates -> rates.getCode().equals(currencyTo)).findFirst().get().getAsk();

        return result = (amount * valueFrom) / valueTo;
    }
}
