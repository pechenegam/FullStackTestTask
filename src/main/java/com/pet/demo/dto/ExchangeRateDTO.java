package com.pet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDTO {
    private Long id;
    private String currency;
    private Double rate;
    private Date ecbDate;
}