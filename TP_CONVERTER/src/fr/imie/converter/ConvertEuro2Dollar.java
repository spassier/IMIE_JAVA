package fr.imie.converter;

import javax.inject.Named;

@Named("Euro2Dollar")
public class ConvertEuro2Dollar implements IConvert {
	private Float ratioEuroDollar = new Float(0.80); 
	
	@Override
	public Float convert(Float value) {
		// TODO Auto-generated method stub
		return value * ratioEuroDollar;
	}

}
