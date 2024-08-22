package br.com.opbdntr.apigatewaytest;

import br.com.opbdntr.apigatewaytest.exceptions.MathOperationException;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
                      throws Exception
    {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new MathOperationException("Necessário ser numero!");
        }

        return converterNumber(numberOne) + converterNumber(numberTwo);
    }

    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new MathOperationException("Use apenas numeros");
        }

        return converterNumber(numberOne) - converterNumber(numberTwo);
    }

    @RequestMapping(value = "mut/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double mut(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new MathOperationException("Use apenas numeros");
        }

        return converterNumber(numberOne) * converterNumber(numberTwo);
    }

    @RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    private Double div (@PathVariable(value = "numberOne")String numberOne,
                        @PathVariable(value = "numberTwo")String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new MathOperationException("Use apenas numeros");
        }

        return converterNumber(numberOne) / converterNumber(numberTwo);
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception
    {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new MathOperationException("Necessário ser numero!");
        }

        return (converterNumber(numberOne) + converterNumber(numberTwo)) / 2;
    }

    @RequestMapping(value = "raiz/{numberOne}", method = RequestMethod.GET)
    private Double raiz (@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)){
            throw new MathOperationException("Use apenas numeros");
        }

        return tiraRaiz(numberOne);
    }

    private Double converterNumber(String strNumber) throws Exception {
        replaceNumber(strNumber);
        if (isNumeric(strNumber)) return Double.parseDouble(strNumber);
        return 0D;
    }

    private boolean isNumeric(String strNumber) throws Exception {
        replaceNumber(strNumber);
        return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private String replaceNumber(String strNumber) throws Exception{
        if (strNumber == null) throw new MathOperationException("Não aceitamos numeros nulos");
        return strNumber.replaceAll(",", ".");
    }

    private Double tiraRaiz(String number) throws Exception {
        replaceNumber(number);
        double result = Double.parseDouble(number);
        return Math.sqrt(result);
    }

}
