package br.com.opbdntr.apigatewaytest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathOperationException extends RuntimeException  {

    public MathOperationException(String ex){
        super(ex);
    }
    private static final long serializableVersionUID = 1L;
}
