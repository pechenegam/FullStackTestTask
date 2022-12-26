package com.pet.demo.dto.request;

import lombok.Data;

@Data
public class ConversionRequest {
    private String currencyFrom;
    private String currencyTo;
    private Double fromValue;
}
