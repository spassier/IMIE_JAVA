package fr.imie.converter;

import javax.inject.Named;

@Named("Dollar2Euro")
public class ConvertDollar2Euro implements IConvert {
	private Float ratioDollarEuro = new Float(1.20); 
	
	public Float convert(Float value) {
		return value * ratioDollarEuro;
	}

}
