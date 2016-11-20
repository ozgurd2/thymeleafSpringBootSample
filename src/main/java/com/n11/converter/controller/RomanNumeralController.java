package com.n11.converter.controller;

import com.n11.common.exception.FieldNotValidException;
import com.n11.common.exception.FieldRangeNotValidException;
import com.n11.common.model.ResultWrapper;
import com.n11.converter.service.NumeralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @Author ozgur on 19.11.2016.
 * A Controller for roman numeral operations
 */
@Controller
public class RomanNumeralController {

    private static final Logger log = LoggerFactory.getLogger(RomanNumeralController.class);

    @Autowired
    private NumeralService romanNumeralService;

    /**
     * this method is an entry point of our application
     * @return a page view representation
     */
    @RequestMapping(value = "/")
    public String index() {
        log.debug("request to roman numeral index page");
        return "index";
    }

    /**
     * GET /roman/{number}  -> number is positive Integer
     * @param number get a positive integer number.
     * @return a string that represent custom error or Roman numerals
     */
    @RequestMapping(value = "/roman/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper> findRomanNumber(@PathVariable("number") Integer number) {
        log.debug("request to roman numeral convert method");
        ResultWrapper result=new ResultWrapper();
        try {
            result.setValue(romanNumeralService.getNumber(number));
        } catch (final FieldNotValidException e) {
            log.error("field : number is not valid!", e);
            return  ResponseEntity.badRequest().body(new ResultWrapper(e.getMessage()));
        } catch (final FieldRangeNotValidException e){
            log.error("field : number can not be lower than 1!", e);
            return  ResponseEntity.badRequest().body(new ResultWrapper(e.getMessage()));
        }
        return ResponseEntity.ok().body(result);
    }

    /**
     * Controller advice to translate exceptions server side;
     * @return a string , client friendly format of exception
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ResponseEntity<ResultWrapper>  handleNullPointerException(){
        return ResponseEntity.badRequest().body( new ResultWrapper("field : number, is not numeric , wrong format or range exceeded"));
    }


    /**
     * Controller advice to translate exceptions server side;
     * @return a string , client friendly format of exception
     */
    @ExceptionHandler(StackOverflowError.class)
    @ResponseBody
    public ResponseEntity<ResultWrapper>  handleStackOverflowError(){
        return  ResponseEntity.badRequest().body(new ResultWrapper("field : number, is too big for processing :(  (stack over flow)"));
    }

}
