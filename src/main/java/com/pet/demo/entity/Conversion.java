package com.pet.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Conversion extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "conversion_from_id")
    private ExchangeRate fromExchange;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "conversion_to_id")
    private ExchangeRate toExchange;

    private LocalDate ecbDate;

    private Double fromValue;
    private Double toValue;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id")
    private User user;

}