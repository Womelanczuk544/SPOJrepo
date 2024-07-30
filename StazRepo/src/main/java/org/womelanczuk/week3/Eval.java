package org.womelanczuk.week3;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Eval {

    public static BigInteger firstRequ(int a, int b){
        if(b == (a+1))
            return BigInteger.ONE;
        else{
            int m = (a+b)/2;
            BigInteger result =(firstRequ(a,m).multiply(secondRequ(m,b)));
            return result.add(firstRequ(m,b));
        }
    }
    public static BigInteger secondRequ(int a, int b){
        if(b == (a+1))
            return BigInteger.valueOf(b);
        else{
            int m = (a+b)/2;
            return secondRequ(a,m).multiply(secondRequ(m,b));
        }
    }
    public static void main(String[] args) {
        BigDecimal temp1 = new BigDecimal(firstRequ(0,200000));
        BigDecimal temp2 = new BigDecimal(secondRequ(0,200000));
        BigDecimal temp3 = temp1.divide(temp2,200000,BigDecimal.ROUND_HALF_UP);
        BigDecimal e = BigDecimal.ONE.add(temp3);
        System.out.println(e);
    }
}
