package br.com.guisamp.rest_with_spring_boot_and_java_erudio;

import org.springframework.web.bind.annotation.RestController;
import br.com.guisamp.rest_with_spring_boot_and_java_erudio.exceptions.UnsuportedMathOperationExceptione;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/calculator")
public class MathController {
    
    @GetMapping("/basicoperations/{operator}/{strNumberOne}/{strNumberTwo}")   
    public Double operacoesBasicas(@PathVariable String strNumberOne, @PathVariable String operator, @PathVariable String strNumberTwo){
        if(!isNumeric(strNumberOne) || (!isNumeric(strNumberTwo))){
            throw new UnsuportedMathOperationExceptione("Parametro tem que ser do tipo númerico");
        }

        Double numberOne = convertToDouble(strNumberOne);
        Double numberTwo = convertToDouble(strNumberTwo);
        switch (operator) {
            case "sum":
                return numberOne + numberTwo;
            
            case "sub":
                return numberOne - numberTwo;
            
            case "mul":
                return numberOne * numberTwo;
            
            case "div":
                if(numberTwo == 0){
                    throw new UnsuportedMathOperationExceptione("Divisor não pode ser igual a zero");
                }
                return numberOne / numberTwo;
                          
            default:
                throw new UnsuportedMathOperationExceptione("Digite um operador válido");
        }
    }

    @GetMapping("/squareroot/{number}")
    public Double raizQuadrada(@PathVariable String number) {
        if (!isNumeric(number)) {
            throw new UnsuportedMathOperationExceptione("Parâmetro tem que ser do tipo numérico");
        }

        double num = convertToDouble(number);
        if (num < 0) {
            throw new UnsuportedMathOperationExceptione("Não é possível calcular a raiz quadrada de um número negativo");
        }

        return Math.sqrt(num);
    }

    @GetMapping("/average/{strNumberOne}/{strNumberTwo}/{strNumberThree}")
    public Double getMethodName(@PathVariable String strNumberOne, @PathVariable String strNumberTwo, @PathVariable String strNumberThree) {
        if(!isNumeric(strNumberOne) || (!isNumeric(strNumberTwo)) || (!isNumeric(strNumberThree)) ){
            throw new UnsuportedMathOperationExceptione("Parâmetro tem que ser do tipo numérico");
        }

        return (convertToDouble(strNumberOne) + convertToDouble(strNumberTwo) + convertToDouble(strNumberThree))/3; 
    }
    

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0d; 
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false; 
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
