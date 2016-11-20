package com.n11.converter.service.impl;

import com.n11.common.exception.FieldNotValidException;
import com.n11.common.exception.FieldRangeNotValidException;
import com.n11.converter.repository.NumeralRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * @Author  ozgur on 20.11.2016.
 * unit test for RomanNumeralServiceImpl
 */
@RunWith(MockitoJUnitRunner.class)
public class RomanNumeralServiceImplTest {

    @Mock
    private NumeralRepository numeralRepository;

    @InjectMocks // injects mocks autowired fields
    private RomanNumeralServiceImpl romanNumeralService;

    @Test
    public void getNumber(){
        when(numeralRepository.getNumber(anyInt())).thenReturn("V");
        final String result=romanNumeralService.getNumber(5);
        assertThat(result,is(equalTo("V")));
    }

    @Test
    public void getNumberWithNullInput(){
        try{
            romanNumeralService.getNumber(null);
            fail("An error should have been thrown");
        }catch (final FieldNotValidException e){
            assertThat(e.getFieldName(),is(equalTo("romanNumber")));
        }
    }

    @Test
    public void getNumberWithLowerThanOne(){
        try{
            romanNumeralService.getNumber(-10);
            fail("An error should have been thrown");
        }catch (final FieldRangeNotValidException e){
            assertThat(e.getFieldName(),is(equalTo("romanNumber")));
        }
    }

}