package br.com.Grizzlyess.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {
    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public double sum(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2))throw new IllegalArgumentException();
        return convertToDouble(number1) + convertToDouble(number2);
    }

    private double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new IllegalArgumentException();
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
