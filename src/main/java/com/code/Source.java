package com.code;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.BufferedWriter;
import java.math.BigInteger;

public class Source implements HttpFunction {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        BufferedWriter writer = response.getWriter();

        writer.write("Result is:" + factorial(new BigInteger("4000")));
    }

    private BigInteger factorial(BigInteger num) {
        BigInteger total;
        if (num.equals(new BigInteger("1"))) {
            return new BigInteger("1");
        } else {
            total = num.multiply(factorial(num.subtract(new BigInteger("1"))));
        }
        return total;
    }
}
