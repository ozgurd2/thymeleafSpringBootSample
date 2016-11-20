package com.n11.converter.repository.impl;

import com.n11.converter.repository.NumeralRepository;
import com.n11.common.util.RomanNumberConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @Author ozgur on 19.11.2016.
 * A repository for Roman numeral operations
 */
@Repository
public class RomanNumeralRepositoryImpl implements NumeralRepository {

    private static final Logger log = LoggerFactory.getLogger(RomanNumeralRepositoryImpl.class);

    /**
     * This class connected a util for roman numeral {@Link RomanNumberConverter}  and call toRoman method
     * @param number a positive integer number
     * @return a string represents a roman numeral
     */
    @Override
    public String getNumber(Integer number) {
        log.debug("request to convert roman numeral for : "+ number);//todo : format hale getir
        return  RomanNumberConverter.intToRoman(number);
    }

}
