package com.pet.demo.controller;

import com.pet.demo.dto.ConversionDTO;
import com.pet.demo.dto.request.ConversionRequest;
import com.pet.demo.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conversions")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    @GetMapping
    public List<ConversionDTO> getMyConversions() {
        return conversionService.getMyConversions();
    }

    @GetMapping("/all")
    public List<ConversionDTO> getAllConversions() {
        return conversionService.getAllConversions();
    }

    @GetMapping("/{id}")
    public ConversionDTO getConversionById(@PathVariable Long id) {
        return conversionService.getConversionById(id);
    }

    @PostMapping
    public ConversionDTO convert(@RequestBody ConversionRequest conversionRequest) {
        return conversionService.convert(conversionRequest);
    }

}
