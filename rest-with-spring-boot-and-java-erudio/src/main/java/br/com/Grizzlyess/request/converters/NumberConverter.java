package br.com.Grizzlyess.request.converters;

import br.com.Grizzlyess.exception.ResourceNotFoundException;

public class NumberConverter {
    public static double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty())
            throw new ResourceNotFoundException("Please, set a numeric value|");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric( String strNumber)
    {
        if (strNumber == null || strNumber.isEmpty())
            return true;
        String number = strNumber.replace(",",".");
        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
