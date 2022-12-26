package com.pet.demo.repository;

import com.pet.demo.entity.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRepository extends CrudRepository<ExchangeRate, Long> {
    List<ExchangeRate> findByEcbDate(LocalDate date);

    ExchangeRate findFirstByOrderByEcbDateDesc();

    List<ExchangeRate> findAll();

}
