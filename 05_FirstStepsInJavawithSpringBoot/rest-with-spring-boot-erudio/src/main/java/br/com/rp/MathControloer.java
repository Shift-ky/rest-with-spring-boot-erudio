package br.com.rp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rp.exception.UnsupportedMathOperationException;


@RestController
public class MathControloer {
	
	private static final String template = "hello, %s!";
	
	
	private final AtomicLong counter = new AtomicLong();
	
	//Anotação para passar os parametros                    //Metopdo explicito    
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws  Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		
		
		return covertToDouble(numberOne) + covertToDouble(numberTwo);
		
	}
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws  Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		
		
		return covertToDouble(numberOne) - covertToDouble(numberTwo);
		
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws  Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		
		
		return covertToDouble(numberOne) * covertToDouble(numberTwo);
		
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws  Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		
		
		return covertToDouble(numberOne) / covertToDouble(numberTwo);
		
	}
	
	@RequestMapping(value = "/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws  Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		
		
		return (covertToDouble(numberOne) * covertToDouble(numberTwo)/2);
		
	}
	@RequestMapping(value = "/square/{numberOne}", method=RequestMethod.GET)
	public Double square(
			@PathVariable(value = "numberOne") String numberOne
			
			) throws  Exception{
		if(!isNumeric(numberOne)){
			throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		
		
		return (Math.sqrt(covertToDouble(numberOne)));
		
	}

	private Double covertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
