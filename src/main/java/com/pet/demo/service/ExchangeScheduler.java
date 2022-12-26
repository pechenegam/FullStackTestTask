package com.pet.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeScheduler {

    private final ExchangeService exchangeService;

    @Scheduled(cron = "${exchange.cron}")
    public void exchangeScheduler() {
        exchangeService.loadExchanges();
    }

}
