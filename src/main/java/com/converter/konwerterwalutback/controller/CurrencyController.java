package com.converter.konwerterwalutback.controller;

import com.converter.konwerterwalutback.domain.Rates;
import com.converter.konwerterwalutback.nbp.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CurrencyController {

    @Autowired
    NbpClient nbpClient;

    @GetMapping(value = "/currencies")
    public List<Rates> getCurrencies() {
        return nbpClient.getAllCurrencies();
    }
}
