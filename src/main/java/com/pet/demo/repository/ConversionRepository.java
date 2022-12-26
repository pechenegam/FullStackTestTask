package com.pet.demo.repository;

import com.pet.demo.entity.Conversion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ConversionRepository extends CrudRepository<Conversion, Long> {

    Optional<Conversion> findById(Long id);

    List<Conversion> findAllByUser_Id(Long id);

    List<Conversion> findAll();

}
