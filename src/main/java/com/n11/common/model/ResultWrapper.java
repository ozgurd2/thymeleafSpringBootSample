package com.n11.common.model;

/**
 * @Author ozgur on 20.11.2016.
 * result wrapper class ; json conversion for single string
 */
public class ResultWrapper {

    private String value;

    public ResultWrapper(String value) {
        this.value = value;
    }

    public ResultWrapper() {
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
