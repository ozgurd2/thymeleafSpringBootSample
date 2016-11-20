package com.n11.converter.controller;

import com.n11.common.exception.FieldNotValidException;
import com.n11.common.exception.FieldRangeNotValidException;
import com.n11.common.model.ResultWrapper;
import com.n11.converter.service.NumeralService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * @Author ozgur on 20.11.2016.
 * Unit test for RomanNumeralController
 */
@RunWith(MockitoJUnitRunner.class)
public class RomanNumeralControllerTest {

    @InjectMocks
    private RomanNumeralController romanNumeralController;

    @Mock
    private NumeralService romanNumeralService;

    @Test
    public void findRomanNumber() throws Exception {
        when(romanNumeralService.getNumber(anyInt())).thenReturn("V");
        ResponseEntity<ResultWrapper> response = romanNumeralController.findRomanNumber(5);
        assertThat(response.getBody().getValue(), is(equalTo("V")));
    }

    @Test
    public void findRomanNumberWithNull() {
        when(romanNumeralService.getNumber(anyInt())).thenThrow(FieldNotValidException.class);
        ResponseEntity<ResultWrapper> result = romanNumeralController.findRomanNumber(null);
        assertThat(result.getStatusCode(),is(equalTo(HttpStatus.BAD_REQUEST)));
    }

    @Test
    public void findRomanNumberWithNegativeNumber() {
        when(romanNumeralService.getNumber(anyInt())).thenThrow(FieldRangeNotValidException.class);
        ResponseEntity<ResultWrapper> result = romanNumeralController.findRomanNumber(-900);
        assertThat(result.getStatusCode(),is(equalTo(HttpStatus.BAD_REQUEST)));
    }

}