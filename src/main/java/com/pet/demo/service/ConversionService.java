package com.pet.demo.service;

import com.pet.demo.dto.ConversionDTO;
import com.pet.demo.dto.request.ConversionRequest;
import com.pet.demo.entity.Conversion;
import com.pet.demo.entity.ExchangeRate;
import com.pet.demo.entity.User;
import com.pet.demo.exception.CurrencyNotFoundException;
import com.pet.demo.exception.EntityNotFoundException;
import com.pet.demo.mappers.ConversionMapper;
import com.pet.demo.repository.ConversionRepository;
import com.pet.demo.repository.UserRepository;
import com.pet.demo.security.services.UserDetailsImpl;
import com.pet.demo.utils.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ConversionService {

    private static final String EXCEPTION_SERVICE = "Conversion";

    private final ConversionRepository conversionRepository;
    private final UserRepository userRepository;
    private final ExchangeService exchangeService;
    private final ConversionMapper conversionMapper;

    public List<ConversionDTO> getMyConversions() {
        return Optional.ofNullable(AuthenticatedUser.getAuthenticatedUser())
                .map(UserDetailsImpl::getId)
                .map(conversionRepository::findAllByUser_Id)
                .map(conversionMapper::destinationToSourceList)
                .orElseThrow();
    }

    public List<ConversionDTO> getAllConversions() {
        List<Conversion> conversions = conversionRepository.findAll();
        return conversionMapper.destinationToSourceList(conversions);
    }

    public ConversionDTO getConversionById(Long id) {
        return conversionRepository.findById(id)
                .map(conversionMapper::destinationToSource)
                .orElseThrow(() -> new EntityNotFoundException(EXCEPTION_SERVICE, id));
    }

    public ConversionDTO convert(ConversionRequest conversionRequest) {
        Long userId = AuthenticatedUser.getAuthenticatedUser().getId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(EXCEPTION_SERVICE, userId));

        List<ExchangeRate> exchangeRateDTOS = exchangeService.getExchanges();

        ExchangeRate exchangeRateFrom = takeExchangeRateByCurrency(exchangeRateDTOS, conversionRequest.getCurrencyFrom());
        ExchangeRate exchangeRateTo = takeExchangeRateByCurrency(exchangeRateDTOS, conversionRequest.getCurrencyTo());

        LocalDate ecbDate = exchangeRateFrom.getEcbDate();

        Double fromValue = conversionRequest.getFromValue();
        Double toValue = resultValueByRate(fromValue, exchangeRateFrom.getRate(), exchangeRateTo.getRate());
        Conversion conversion = Conversion.builder()
                .fromExchange(exchangeRateFrom)
                .toExchange(exchangeRateTo)
                .ecbDate(ecbDate)
                .fromValue(fromValue)
                .toValue(toValue)
                .user(user).build();
        conversionRepository.save(conversion);

        return conversionMapper.destinationToSource(conversion);
    }

    private Double resultValueByRate(Double fromValue, Double fromRate, Double toRate) {
        Double toValue = (fromValue / fromRate * toRate);
        toValue = Double.valueOf(new DecimalFormat("#0.000").format(toValue));
        return toValue;
    }

    private ExchangeRate takeExchangeRateByCurrency(List<ExchangeRate> exchangeRates, String currency) {
        return exchangeRates.stream()
                .filter(exchangeRateDTO -> currency.equals(exchangeRateDTO.getCurrency()))
                .findFirst()
                .orElseThrow(CurrencyNotFoundException::new);
    }

}

