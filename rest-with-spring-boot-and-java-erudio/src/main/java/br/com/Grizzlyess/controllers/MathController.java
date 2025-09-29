package br.com.Grizzlyess.controllers;

import br.com.Grizzlyess.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public double sum(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");
        return convertToDouble(number1) + convertToDouble(number2);
    }

    @RequestMapping("/sub/{number1}/{number2}")
    public double sub(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");
        return convertToDouble(number1) - convertToDouble(number2);
    }

    @RequestMapping("/div/{number1}/{number2}")
    public double div(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");

        if (number2 == "0")
            throw new UnsupportedMathOperationException("Denominador não pode ser 0");
        return convertToDouble(number1) - convertToDouble(number2);
    }

    @RequestMapping("/med/{number1}/{number2}")
    public double med(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");

        return (convertToDouble(number1) + convertToDouble(number2))/2.0;
    }

    @RequestMapping("/raiz/{number1}/{number2}")
    public double raiz(@PathVariable("number1") String number1) throws Exception {
        if(!isNumeric(number1))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");

        return Math.sqrt(convertToDouble(number1));
    }


    private double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please, set a numeric value|");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric( String strNumber)
    {
        if (strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
