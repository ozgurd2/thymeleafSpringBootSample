package com.n11.common.exception;

/**
 * @Author ozgur on 20.11.2016.
 * Custom field not found exception which can be send on the clint side
 * For Example  :
 * <pre>
 * throw new FieldNotValidException(&quot;fieldName&quot;, &quot;message&quot;);
 * </pre>
 */
public class FieldNotValidException extends RuntimeException {

    private final String fieldName;

    public FieldNotValidException(final String fieldName, final String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return "FieldNotValidException [fieldName=" + fieldName + "]";
    }

}
