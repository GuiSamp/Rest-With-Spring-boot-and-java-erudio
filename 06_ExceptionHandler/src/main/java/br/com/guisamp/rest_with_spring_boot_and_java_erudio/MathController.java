package br.com.guisamp.rest_with_spring_boot_and_java_erudio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.guisamp.rest_with_spring_boot_and_java_erudio.exceptions.UnsuportedMathOperationExceptione;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/calculadora/{numberOne}/{i}/{numberTwo}")
public class MathController {
	
	
	
	@GetMapping("/somar/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationExceptione("Por favor digite um número");
        }
        Double result = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return result;
    }
	
	@GetMapping("/subtrair/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExceptione("Por favor digite um número");
		}
		
		Double result = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return result;
	}
	
	@GetMapping("/multiplicar/{numberOne}/{numberTwo}")
	public Double mul(@PathVariable String numberOne, @PathVariable String numberTwo) {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExceptione("Por favor digite um número");
		}
		
		Double result = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return result;
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
