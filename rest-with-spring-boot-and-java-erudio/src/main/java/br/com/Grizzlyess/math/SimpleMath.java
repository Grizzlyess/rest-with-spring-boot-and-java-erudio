package br.com.Grizzlyess.math;

import br.com.Grizzlyess.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {

    public double sum(Double number1, Double number2){

        return number1 + number2;
    }

    public double sub(Double number1, Double number2) {

        return number1 - number2;
    }

    public double med(Double number1, Double number2) {

        return (number1 + number2)/2.0;
    }

    public double div(Double number1, Double number2) {

        return number1 / number2;
    }

    public double raiz(Double number1) {

        return Math.sqrt(number1);
    }






}
