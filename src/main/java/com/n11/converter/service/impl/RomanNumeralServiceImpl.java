package com.n11.converter.service.impl;

import com.n11.common.exception.FieldNotValidException;
import com.n11.common.exception.FieldRangeNotValidException;
import com.n11.converter.repository.NumeralRepository;
import com.n11.converter.service.NumeralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ozgur on 20.11.2016.
 * A Service class between repository and controller for roman numeral operations
 */
@Service
public class RomanNumeralServiceImpl implements NumeralService {

    private static final Logger log = LoggerFactory.getLogger(RomanNumeralServiceImpl.class);

    @Autowired
    private NumeralRepository numeralRepository;

    /**
     * a service methods validates a param and return a string of roman numeral
     *
     * @param number
     * @return
     */
    @Override
    public String getNumber(Integer number) {
        log.debug("roman number converter service class called ...");
        if (number == null) {
            throw new FieldNotValidException("romanNumber", "Field can not left empty!");
        }
        if (number < 1) {
            throw new FieldRangeNotValidException("romanNumber", "Field can not be lower than 1!");
        }
        return numeralRepository.getNumber(number);
    }


}
