package com.n11.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

/**
 * @Author ozgur on 20.11.2016.
 * a util class for roman numeral convert operation
 */
public class RomanNumberConverter {

    private static final Logger log = LoggerFactory.getLogger(RomanNumberConverter.class);

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    /**
     * this method returns a ROMAN Numeral equivalent of (x >=1) Integer number.
     * @param num A Integer Number.
     * @return A String that represent a roman numeral.
     */
    public static String intToRoman(int num) {
        log.debug("request to convert roman number utility");
        StringBuilder sb = new StringBuilder();
        int[] ks = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for (int k : ks) {
            while (num >= k) {
                num -= k;
                sb.append(map.get(k));
            }
        }
        return sb.toString();
    }

}
