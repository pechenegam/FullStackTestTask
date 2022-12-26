package com.pet.demo.controller;

import com.pet.demo.dto.ExchangeRateDTO;
import com.pet.demo.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchanges")
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping()
    public List<ExchangeRateDTO> getExchangeRates() {
        return exchangeService.getExchangeRates();
    }

}
