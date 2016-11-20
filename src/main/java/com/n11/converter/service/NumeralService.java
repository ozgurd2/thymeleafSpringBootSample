package com.n11.converter.service;

import com.n11.common.exception.FieldNotValidException;
import com.n11.common.exception.FieldRangeNotValidException;

/**
 * Created by ozgur on 20.11.2016.
 */
public interface NumeralService {

    String getNumber(Integer number) throws FieldNotValidException,FieldRangeNotValidException;

}
