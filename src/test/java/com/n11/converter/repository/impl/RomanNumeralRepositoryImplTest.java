package com.n11.converter.repository.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @Author  ozgur on 20.11.2016.
 * Unit test for RomanNumeralRepositoryImpl.class
 */
public class RomanNumeralRepositoryImplTest {

    /**
     * im not using mockito here because not it hasnt much dependency for mock
     */

    private RomanNumeralRepositoryImpl romanNumeralRepository = new RomanNumeralRepositoryImpl();

    @Test
    public void getNumber() {
        Integer given = 5; //suppose 5
        assertThat(romanNumeralRepository.getNumber(given), is(equalTo("V")));
    }

}