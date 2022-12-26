package com.pet.demo.service;

import com.pet.demo.dto.ExchangeRateDTO;
import com.pet.demo.entity.ExchangeRate;
import com.pet.demo.mappers.ExchangeRateMapper;
import com.pet.demo.repository.ExchangeRepository;
import com.pet.demo.utils.ExchangeProperties;
import com.pet.demo.utils.parser.Envelope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class ExchangeService {
    private final WebClient webClient;
    private final ExchangeRepository exchangeRepository;
    private final ExchangeRateMapper exchangeRateMapper;

    private final ExchangeProperties exchangeProperties;

    @PostConstruct
    public List<ExchangeRate> getExchanges() {
        List<ExchangeRate> exchangeRates = exchangeRepository.findByEcbDate(toDay());

        if (exchangeRates.isEmpty()) {
            ExchangeRate latestRate = exchangeRepository.findFirstByOrderByEcbDateDesc();

            if (latestRate == null || !(toDay().equals(latestRate.getEcbDate()))) {
                exchangeRates = loadExchanges(latestRate);
            } else {
                exchangeRates = exchangeRepository.findByEcbDate(latestRate.getEcbDate());
            }
        }
        return exchangeRates;
    }

    public List<ExchangeRate> loadExchanges(ExchangeRate latestRate) {
        Envelope block = getEnvelope();
        if (block == null) {
            return new ArrayList<>();
        } else {
            List<ExchangeRate> exchangeRates = exchangeRateMapper.destinationToSource(block);
            if (latestRate == null || !latestRate.getEcbDate().equals(exchangeRates.get(0).getEcbDate())) {
                exchangeRepository.saveAll(exchangeRates);
            }
            return exchangeRates;
        }
    }

    public List<ExchangeRateDTO> getExchangeRates() {
        return exchangeRateMapper.destinationToListSource(getExchanges());
    }

    public Envelope getEnvelope() {
        return webClient
                .get()
                .uri(exchangeProperties.getRatesUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(Envelope.class)
                .block();
    }

    public LocalDate toDay() {
        return LocalDate.now();
    }
}
