package br.com.opbdntr.apigatewaytest.math;

import java.util.concurrent.atomic.AtomicLong;

public class SimpleMath {
    private final AtomicLong counter = new AtomicLong();

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double mut(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double div(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double med (Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    public Double raiz(Double numberOne) {
        return Math.sqrt(numberOne);
    }
}
