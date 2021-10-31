package com.converter.konwerterwalutback.controller;

import com.converter.konwerterwalutback.domain.Rates;
import com.converter.konwerterwalutback.nbp.NbpClient;
import com.converter.konwerterwalutback.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CurrencyController {

    @Autowired
    NbpClient nbpClient;
    @Autowired
    Service service;

    @GetMapping(value = "/currencies")
    public List<Rates> getCurrencies() {
        return nbpClient.getAllCurrencies();
    }

    @GetMapping(value = "/result")
    @ResponseBody
    public Double showResult(
            @RequestParam Integer amount,
            @RequestParam String currencyFrom,
            @RequestParam String currencyTo) {

        return service.giveResult(amount, currencyFrom, currencyTo);
    }
}
