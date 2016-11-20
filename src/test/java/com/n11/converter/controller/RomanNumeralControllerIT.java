package com.n11.converter.controller;

import com.n11.N11ChallangeApplicationTests;
import com.n11.common.model.ResultWrapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @Author ozgur on 20.11.2016.
 * Integration test for /roman/{number} rest end point
 */
public class RomanNumeralControllerIT extends N11ChallangeApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(RomanNumeralControllerIT.class);

    /**
     * success integration test
     */
    @Test
    public void findRomanNumberTest(){
        log.debug("success integration test for romanNumerals");
        Integer given = 15; //XV

        Map<String, Integer> params = new HashMap<>();
        params.put("number",given);

        ResultWrapper result = restTemplate.getForObject(host + "/roman/{number}", ResultWrapper.class, params);

        assertThat(result.getValue(),is(equalTo("XV")));
    }

    /**
     * fail integration test with negative value
     */
    @Test
    public void findRomanNumberWithNegativeValue(){
        log.debug("negative value  integration test for romanNumerals");
        Integer given = -99;

        Map<String, Integer> params = new HashMap<>();
        params.put("number",given);

        ResponseEntity<ResultWrapper> response = restTemplate.getForEntity(host + "/roman/{number}", ResultWrapper.class, params);

        log.info(response.getBody().getValue());
        assertThat(response.getStatusCode(),is(equalTo(HttpStatus.BAD_REQUEST)));
    }

    /**
     * fail integration test with Not number value
     */
    @Test
    public void findRomanNumberWithNotNumberValue(){
        log.debug("string value  integration test for romanNumerals");

        Map<String, String> params = new HashMap<>();
        params.put("number","stringError");

        ResponseEntity<ResultWrapper> response = restTemplate.getForEntity(host + "/roman/{number}", ResultWrapper.class, params);

        log.info(response.getBody().getValue());
        assertThat(response.getStatusCode(),is(equalTo(HttpStatus.BAD_REQUEST)));
    }

}
