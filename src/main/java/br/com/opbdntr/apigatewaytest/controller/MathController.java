package br.com.opbdntr.apigatewaytest.controller;

import br.com.opbdntr.apigatewaytest.converter.NumberConverter;
import br.com.opbdntr.apigatewaytest.exceptions.MathOperationException;
import br.com.opbdntr.apigatewaytest.math.SimpleMath;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception
    {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new MathOperationException("Necessário ser numero!");
        }

        return math.sum(NumberConverter.converterNumber(numberOne), NumberConverter.converterNumber(numberTwo));
    }

    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new MathOperationException("Use apenas numeros");
        }

        return math.sub(NumberConverter.converterNumber(numberOne), NumberConverter.converterNumber(numberTwo));
    }

    @RequestMapping(value = "mut/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double mut(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new MathOperationException("Use apenas numeros");
        }

        return math.mut(NumberConverter.converterNumber(numberOne), NumberConverter.converterNumber(numberTwo));
    }

    @RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double div (@PathVariable(value = "numberOne")String numberOne,
                        @PathVariable(value = "numberTwo")String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new MathOperationException("Use apenas numeros");
        }

        return math.div(NumberConverter.converterNumber(numberOne), NumberConverter.converterNumber(numberTwo));
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception
    {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new MathOperationException("Necessário ser numero!");
        }

        return math.med(NumberConverter.converterNumber(numberOne), NumberConverter.converterNumber(numberTwo));
    }

    @RequestMapping(value = "raiz/{numberOne}", method = RequestMethod.GET)
    private Double raiz (@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!NumberConverter.isNumeric(numberOne)){
            throw new MathOperationException("Use apenas numeros");
        }

        return math.raiz(NumberConverter.converterNumber(numberOne));
    }

}
