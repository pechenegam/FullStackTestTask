package com.pet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionDTO {
    private Long id;
    private String conversionFrom;
    private String conversionTo;
    private Double rateFrom;
    private Double rateTo;
    private Double fromValue;
    private Double toValue;
    private LocalDate ecbDate;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;
    private Long authorId;
    private String authorUsername;

}
