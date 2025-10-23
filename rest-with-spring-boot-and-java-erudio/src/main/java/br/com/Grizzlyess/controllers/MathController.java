package br.com.Grizzlyess.controllers;
import br.com.Grizzlyess.exception.UnsupportedMathOperationException;
import br.com.Grizzlyess.math.SimpleMath;
import br.com.Grizzlyess.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public double sum(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(NumberConverter.isNumeric(number1) || NumberConverter.isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");
        return math.sum(NumberConverter.convertToDouble(number1),NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/sub/{number1}/{number2}")
    public double sub(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(NumberConverter.isNumeric(number1) || NumberConverter.isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");
        return math.sub(NumberConverter.convertToDouble(number1),NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/div/{number1}/{number2}")
    public double div(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(NumberConverter.isNumeric(number1) || NumberConverter.isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");

        if (number2 == "0")
            throw new UnsupportedMathOperationException("Denominador não pode ser 0");
        return math.div(NumberConverter.convertToDouble(number1),NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/med/{number1}/{number2}")
    public double med(@PathVariable("number1") String number1,
                      @PathVariable("number2") String number2) throws Exception {
        if(NumberConverter.isNumeric(number1) || NumberConverter.isNumeric(number2))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");

        return math.med(NumberConverter.convertToDouble(number1),NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/raiz/{number1}")
    public double raiz(@PathVariable("number1") String number1) throws Exception {
        if(NumberConverter.isNumeric(number1))
            throw new UnsupportedMathOperationException("Please, set a numeric value|");

        if (NumberConverter.convertToDouble(number1) <=0)
            throw new UnsupportedMathOperationException("Digite um numero real positivo");

        return math.raiz(NumberConverter.convertToDouble(number1));
    }



}
