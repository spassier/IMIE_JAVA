package fr.imie.converter;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;

public class Historic implements IHistoric {

	private List<DataGui> historic = new ArrayList<DataGui>();

	@Override
	public List<DataGui> getHistoric() {
		return historic;
	}
	
	@Override
	public void AddHistoric(DataGui data)
	{
		historic.add(data);
	}


}
