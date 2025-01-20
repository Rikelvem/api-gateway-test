package br.com.opbdntr.apigatewaytest.converter;

import br.com.opbdntr.apigatewaytest.exceptions.MathOperationException;

public class NumberConverter {
    public static Double converterNumber(String strNumber) throws Exception {
        replaceNumber(strNumber);
        if (isNumeric(strNumber)) return Double.parseDouble(strNumber);
        return 0D;
    }

    public static boolean isNumeric(String strNumber) throws Exception {
        replaceNumber(strNumber);
        return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private static String replaceNumber(String strNumber) throws Exception{
        if (strNumber == null) throw new MathOperationException("Não aceitamos numeros nulos");
        return strNumber.replaceAll(",", ".");
    }

    public static Double tiraRaiz(String number) throws Exception {
        replaceNumber(number);
        double result = Double.parseDouble(number);
        return Math.sqrt(result);
    }
}
